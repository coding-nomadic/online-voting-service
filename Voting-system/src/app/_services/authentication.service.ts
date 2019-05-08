import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { environment } from '../../environments/environment';
import { User } from '../_models';
import { Vote } from '../_models/vote';

@Injectable()
export class AuthenticationService {
    constructor(private http: HttpClient) { }
    loginUser(voterCardNumber: string) {
        return this.http.get(`${environment.apiUrl}/getAllRegisteredVoters`)
            .pipe(map(data => {
                console.log("inside....");
                return data;
            }));
    }
    authenticateOTP(otp:string) {
        return this.http.get(`${environment.apiUrl}/getAllOTPs`)
            .pipe(map(data => {  
                return data;
            }));
        }
    loginAdmin(username: string,password:string) {
        return this.http.get(`${environment.apiUrl}/getAllAdminUsers`)
            .pipe(map(data => {  
                return data;
            }));
    }
    fetchAdminVotes() {
        return this.http.get(`${environment.apiUrl}/getAllVotesForAdmin`)
            .pipe(map(data => {  
                console.log("-------inside this method------");
                return data;
            }));
    }
    vote(vote:Vote) {
        console.log("values coming are :"+vote.voterCardNumber+" "+vote.candidate);
        return this.http.get(`${environment.apiUrl}/addVote?voterCardNumber=`+vote.voterCardNumber+"&candidateGroup="+vote.candidate)
            .pipe(map(data => {
                console.log("-----------------------2");
                return data;
            }));
    }
    logout() {
        // remove user from local storage to log user out
        localStorage.removeItem('currentUser');
    }
}