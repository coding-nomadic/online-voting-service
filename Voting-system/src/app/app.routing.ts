import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home';
import { LoginComponent } from './login';
import { RegisterComponent } from './register';
import { AuthGuard } from './_guards';
import { VoteComponent } from './vote';
import { AdminComponent } from './admin';
import { AdminPageComponent } from './adminpage';
import { OTPComponent } from './otp';
import { RegisteredLoginComponent } from './registeredlogin';

const appRoutes: Routes = [
    { path: '', component: HomeComponent, canActivate: [AuthGuard] },
    { path: 'login', component: LoginComponent },
    { path: 'vote', component: VoteComponent },
    { path: 'admin', component: AdminComponent },
    { path: 'otp', component: OTPComponent },
    { path: 'registeredLogin', component: RegisteredLoginComponent },
    { path: 'adminpage', component: AdminPageComponent },
    { path: 'register', component: RegisterComponent },
    // otherwise redirect to home
    { path: '**', redirectTo: '' }
];

export const routing = RouterModule.forRoot(appRoutes);