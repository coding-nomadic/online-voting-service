import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import { AlertService, AuthenticationService,UserService } from '../_services';

@Component({templateUrl: 'registeredlogin.component.html'})
export class RegisteredLoginComponent implements OnInit {
    loginForm: FormGroup;
    loading = false;
    submitted = false;
    returnUrl: string;
    constructor(
        private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private userService: UserService,
        private authenticationService: AuthenticationService,
        private alertService: AlertService) {}
    ngOnInit() {
        this.loginForm = this.formBuilder.group({
            voterCardNumber: ['', Validators.required]           
        });
        // reset login status
        this.authenticationService.logout();
        // get return url from route parameters or default to '/'
        this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
    }
    // convenience getter for easy access to form fields
    get f() { return this.loginForm.controls; }
    onSubmit() {
        this.submitted = true;
        // stop here if form is invalid
        if (this.loginForm.invalid) {
            return;
        }
        this.loading = true;
        this.authenticationService.loginUser(this.f.voterCardNumber.value)
            .pipe(first())
            .subscribe(
                data => {
                    console.log("--------"+JSON.stringify(data));
                    let jsonArray=JSON.parse(JSON.stringify(data));                   
                    for(let i=0;i<jsonArray.length;i++){
                    let obj = jsonArray[i];
                    console.log(obj);
                    if(obj.voterCardNumber==this.f.voterCardNumber.value){
                        console.log("true .....matched");
                        this.userService.sendOTP(obj.email,this.f.voterCardNumber.value)
                        .pipe(first())
                        .subscribe(
                            data => {
                                console.log("true ...."+obj.email+" "+this.f.voterCardNumber.value);
                                this.alertService.success('OTP sent successfully in mail..',true);
                                this.router.navigate(['/otp']);
                                this.loading = false;                                
                            } ,
                            error => {
                                this.alertService.success('OTP sent successfully in mail..',true);
                                this.router.navigate(['/otp']);
                                this.loading = false;
                            });
                            break;
                        }else{
                            console.log("false ....");        
                            this.alertService.error("Cant find in database, please register for new one!!");
                            this.loading = false;
                        }    
                   }
                },
                error => {
                    console.log("other ....");
                    this.alertService.error(error);
                    this.loading = false;
                });
    }
}
