import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Departement } from 'src/Models/Departement';
import { DepartementService } from '../departement.service';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  Dep!:Departement[];

  idDepart !:number;
  nomDepart!:String;
 

  DepForm = new FormGroup(
		{
			
			nomDepart : new FormControl('')
		}
		)
    constructor(private service:DepartementService,private router:Router) { }


    ngOnInit(): void {
      this.service.fetchDepartements().subscribe(
        (t)=>{
          this.Dep=t;
        },
        (error)=>{
          console.log(error.status)
        }
      );
    }
    
    SaveDep(data:any)
    {
  
  
     
      this.service.addDepartement(data).subscribe(()=>{},(error)=>{console.log(error);})
      this.router.navigateByUrl("departement/DepartementHome/getParent");
   
    }
  
  
 
	
  }