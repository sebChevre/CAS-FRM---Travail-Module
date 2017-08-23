import { NgModule } from '@angular/core';
import { BrowserModule }  from '@angular/platform-browser';
import { AppComponent } from './app.component';
import {HomeComponent} from "./home/home.component";
import {Routes, RouterModule} from "@angular/router";
import {Http, Response, HttpModule} from '@angular/http';
import {DetailComponent} from "./detail/detail.component";
import {ReactiveFormsModule , FormsModule} from '@angular/forms';
const appRoutes: Routes = [
];

@NgModule({
    imports: [
        BrowserModule,
        RouterModule.forRoot(appRoutes),
        HttpModule,
        ReactiveFormsModule,
        FormsModule
    ],
    declarations: [
        AppComponent,
        HomeComponent,
        DetailComponent
    ],
    bootstrap: [ AppComponent ]
})
export class AppModule { }
