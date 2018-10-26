import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Person } from '../person';

@Component({
  selector: 'app-tbl-person',
  templateUrl: './tbl-person.component.html',
  styleUrls: ['./tbl-person.component.css']
})
export class TblPersonComponent implements OnInit {

  @Input() arrPersons: Array<Person>;

  @Output() evtSelectPerson: EventEmitter<Person> = new  EventEmitter<Person>();

  constructor() { }

  ngOnInit() {
  }

  selectPerson(person: Person) {
    this.evtSelectPerson.emit(person);
  }

}
