﻿import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import { AlertService, AuthenticationService } from '../_services';
import { User } from '../_models';

@Component({templateUrl: 'vote.component.html'})
export class VoteComponent implements OnInit{   
    voteForm: FormGroup;
    User:User;
    loading = false;
    submitted = false;
    returnUrl: string;
    countries = [{
        id: '8f8c6e98',
        name: 'Peter Parker',
        code: 'PP1'
       },
       {
        id: '169fee1a',
        name: 'Ram Prakash',
        code: 'RP2'
       },
       {
        id: '3953154c',
        name: 'Tenzin Sonam',
        code: 'TS3'
       },
       {
        id: '3953154c',
        name: 'Mike',
        code: 'MK2'
       }, {
        id: '3953154c',
        name: 'Paul Ribbon',
        code: 'PR4'
       }
      ]
    constructor(
        private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private authenticationService: AuthenticationService,
        private alertService: AlertService) {}
    ngOnInit() {
        this.voteForm = this.formBuilder.group({
            countryControl: ['Canada']
          });
        this.voteForm = this.formBuilder.group({
            voterCardNumber: ['', Validators.required],
            countryControl: ['', Validators.required]          
        });
        // reset login status
        this.authenticationService.logout();
        // get return url from route parameters or default to '/'
        this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
    }
    // convenience getter for easy access to form fields
    get f() { return this.voteForm.controls; }
    onSubmit() {
        this.submitted = true;
        // stop here if form is invalid
        if (this.voteForm.invalid) {
            return;
        }
        this.loading = true;
        this.authenticationService.vote(this.voteForm.value)
            .pipe(first())
            .subscribe(
                data => {
                    console.log("--insdie---"+data.toString);
                    this.alertService.success('Vote successful', true);
                    this.router.navigate(['/home']);
                },
                error => {
                    this.alertService.success('Vote successful', true);
                    this.router.navigate(['/login']);
                    //this.loading = false;
                });
    }
}
