import { Component, EventEmitter, Input, OnInit, Output, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { Departement } from 'src/Models/Departement';
import { DepartementService } from '../departement.service';
import { GetParentComponent } from '../get-parent/get-parent.component';
@Component({
  selector: 'app-get-child',
  templateUrl: './get-child.component.html',
  styleUrls: ['./get-child.component.css']
})
export class GetChildComponent implements OnInit {
  @Input() departement!:Departement;
  @Input() photoURL:any;

  @Output() notif= new EventEmitter<any>();
  
  @ViewChild(GetParentComponent) c!:GetChildComponent;
  
    constructor(private service:DepartementService,private router:Router) { }
  
    

  ngOnInit(): void {
  }
  Delete()
  {
    this.notif.emit(this.departement);

  }
  UpdateUser(id:number)
  {
    this.router.navigate(['departement/DepartementHome/update',id])
  }
}
