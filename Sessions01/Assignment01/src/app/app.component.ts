import { Component } from '@angular/core';
import { Person } from './person';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  persons: Person[];
  selectedPerson: Person;

  constructor() {
    this.persons = [];
    this.persons.push(new Person('vahid', 'Vakily', 31, 'Mohammad'));
    this.persons.push(new Person('vahid1', 'Vakily1', 31, 'Mohammad1'));
    this.persons.push(new Person('vahid2', 'Vakily2', 31, 'Mohammad2'));
    this.persons.push(new Person('vahid3', 'Vakily3', 31, 'Mohammad3'));
  }

  selectPerson(person: Person) {
    this.selectedPerson = person;
  }
}
