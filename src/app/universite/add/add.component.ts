import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Universite } from 'src/Models/Universite';
import { UniversiteService } from '../universite.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  Constat!:Universite[];

  nomUni !:String;

  ConstatForm = new FormGroup(
		{
			nomUni : new FormControl(''),
		}
		)
    constructor(private service:UniversiteService,private router:Router) { }


    ngOnInit(): void {
      this.service.fetchUniversite().subscribe(
        (t)=>{
          this.Constat=t;
        },
        (error)=>{
          console.log(error.status)
        }
      );
    }
    
    SaveConstat(data:any)
    {
  
  
     
      this.service.addUniversite(data).subscribe(()=>{},(error)=>{console.log(error);})
      this.router.navigateByUrl("universite/UniversiteHome/getParent");
   
    }
  
  
 
	
  }