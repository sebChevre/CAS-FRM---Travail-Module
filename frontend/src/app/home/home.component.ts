/**
 * Created by seb on 24.05.17.
 */
import {Component, ViewChild} from '@angular/core';
import {Http,Response} from "@angular/http";
import {DetailComponent} from "../detail/detail.component";



@Component({
    selector: 'home',
    templateUrl: 'home.component.html',
    styleUrls: ['home.component.css']
})
export class HomeComponent {

    //reference sur le composant detail
    @ViewChild(DetailComponent)
    private detail : DetailComponent;

    //titre du composant
    title = 'Liste des tâches';
    //tableau de la liste des tâches
    results:any;

    displayDetailForm:boolean = false;

    ngOnInit() {

        console.log("on init");

        this.results = [{"id":"tutu"}];

        for (let result in this.results){
            console.log(this.results[result])
        }

        console.log(this.results)

        /**this.http.get("http://localhost:9090/tasks")
            .subscribe(data => {
                console.log(data);

                console.log(data.json());


                    this.results = data.json();


                console.log(this.results)


            })**/
        this.fillList();
    }

    //remplissage du tablea de la liste des tâches
    fillList () {

        this.http.get("http://localhost:9090/tasks")
            .subscribe(data => {
                console.log(data);

                console.log(data.json());


                this.results = data.json();


                console.log(this.results)


            })
    }

    constructor (private http: Http) {

    }

    afterSave(event:any){
        console.log("test ok");
        console.log(event.target);
        console.log(this.detail.isSubmited)

        if(this.detail.isSubmited){
            this.detail.hideForm();
            this.fillList();
            this.results = this.results.slice();
            console.log(typeof this.results)
        }

    }
    //creation d'une tâche
    create () {
        this.detail.showForm();
    }

    //mise à jour de la tâche
    update (id:string) {
        console.log("update" + id);
        this.displayDetailForm = true;
        this.detail.showForm();
    }

    //suppression de la tâche
    delete (id:string) {
        console.log("update" + id);
    }

    //démarrage de la tâche
    start (id:string) {

    }

    //terminer la tâche
    end (id:string) {

    }
}
