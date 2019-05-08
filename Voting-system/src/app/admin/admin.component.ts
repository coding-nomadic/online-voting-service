import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import { AlertService, AuthenticationService } from '../_services';

@Component({templateUrl: 'admin.component.html'})
export class AdminComponent implements OnInit {
    loginForm: FormGroup;
    loading = false;
    submitted = false;
    returnUrl: string;
    constructor(
        private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private authenticationService: AuthenticationService,
        private alertService: AlertService) {}
    ngOnInit() {
        this.loginForm = this.formBuilder.group({
            username: ['', Validators.required],
            password: ['', Validators.required]
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
        if (this.loginForm.invalid) {
            return;
        }
        this.loading = true;
        this.authenticationService.loginAdmin(this.f.username.value, this.f.password.value)
        .pipe(first())
            .subscribe(
                data => {
                    console.log("inside----tenzinn ")
                    let jsonArray=JSON.stringify(data);
                    let jsonArrays=JSON.parse(jsonArray);
                    for(let i=0;i<jsonArrays.length;i++){
                        let obj=jsonArrays[i];
                        console.log(obj);
                        console.log("password from user :"+this.f.password.value);
                        console.log("password in json :"+obj.password);
                        console.log("username from user :"+this.f.username.value);
                        console.log("username in json :"+obj.userName);
                        if(obj.userName==this.f.username.value && obj.password==this.f.password.value){
                            this.alertService.success('Login successful', true);
                            this.router.navigate(['/adminpage']);      
                        }else{
                            this.alertService.error("userName or password wrong!!");
                            this.loading = false;
                        }
                    }
                  //  this.router.navigate([this.returnUrl]);
                },
                error => {
                    this.alertService.error(error);
                    this.loading = false;
                });
    }
}