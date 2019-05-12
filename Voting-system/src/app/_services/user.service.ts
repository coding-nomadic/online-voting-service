import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { environment } from '../../environments/environment';
import { User } from '../_models';

@Injectable()
export class UserService {
    constructor(private http: HttpClient) { }

    getAll() {
        return this.http.get<User[]>(`${environment.apiUrl}/users`);
    }
        
    getById(id: number) {
        return this.http.get(`${environment.apiUrl}/users/` + id);
    }
    register(user: User) {
       return this.http.get(`${environment.apiUrl}/addVoteRegistration?firstName=`+user.firstName+"&lastName="+user.lastName+"&voterCardNumber="+user.voterCardNumber+"&DateOfBirth="+user.dateOfBirth+"&contact="+user.contact+"&email="+user.email);
    }
    update(user: User) {
        return this.http.put(`${environment.apiUrl}/users/` + user.id, user);
    }

    delete(id: number) {
        return this.http.delete(`${environment.apiUrl}/users/` + id);
    }  

    sendOTP(email:string,voterCardNumber:string) {
        console.log("values coming are :"+voterCardNumber+" "+email);
        return this.http.get(`${environment.apiUrl}/sendMail?email=`+email+"&voterCardNumber="+voterCardNumber);
     }  
     sendThankYouMail(email:string,voterCardNumber:string) {
        console.log("values coming are :"+voterCardNumber+" "+email);
        return this.http.get(`${environment.apiUrl}/sendThankYouMail?email=`+email+"&voterCardNumber="+voterCardNumber);
     }    
}