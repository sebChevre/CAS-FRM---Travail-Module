/**
 * Created by seb on 24.05.17.
 */
import {Component, Input, Output} from '@angular/core';
import {Http,Response} from "@angular/http";
import { Task } from './task';
import {FormGroup, FormControl, FormBuilder, FormControlName} from '@angular/forms';
import { Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';



@Component({
    selector: 'detail',
    templateUrl: 'detail.component.html',
    styleUrls: ['detail.component.css']
})
export class DetailComponent {
    public detailForm: FormGroup;
    title = 'Detail component of page';


    results:any;
    isSubmited: boolean = false;

    @Input()
    display :boolean = false;


    ngOnInit() {




        console.log("on init");

        this.results = [{"id":"tutu"}];

        this.detailForm = this._fb.group({
            etat:new FormControl(''),
            description: new FormControl(''),
            duree: new FormControl(''),
            assigneA : new FormControl('')
        });


        for (let result in this.results){
            console.log(this.results[result])
        }

        console.log(this.results)


    }

    constructor (private http: Http,private _fb: FormBuilder) {

    }

    showForm () {
        this.display = true;
    }

    hideForm () {
        this.display = false;
    }

    save(model: Task) {

        this.isSubmited = true;

        console.log(model);

        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });

        this.http.post("http://localhost:9090/task", model, options)
            .map(this.extractData)
            .catch(this.handleErrorObservable)
        .subscribe((response) => {
            console.log(response);

            console.log(this.isSubmited);





        });

        /*
        this.http.post("http://localhost:9090/tasks")
            .subscribe(data => {
                console.log(data);

                console.log(data.json());


                this.results = data.json();


                console.log(this.results)


            })*/
    }




    private extractData(res: Response) {
        let body = res.json();
        return body.data || {};
    }

    private handleErrorObservable (error: Response | any) {
        console.error(error.message || error);
        return Observable.throw(error.message || error);
    }



}
