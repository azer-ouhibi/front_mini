import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Departement } from 'src/Models/Departement';
import { DepartementService } from '../departement.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  constructor(private ac:ActivatedRoute,private service:DepartementService,private router:Router) { }


  isLoading = true;

  departement = new Departement();
  id=this.ac.snapshot.params['id'];
  
  ngOnInit(): void {
    this.getDepartement();
  }
 

  getDepartement()
  {
    this.service.fetchDepartementById(this.id).subscribe(
      (res:Departement)=>
      {
        this.departement=res;
        this.departement.idDepart=res.idDepart;
        this.isLoading = false;
      },
      (error)=>{
        console.log(error)
      }
    );
  }

  UpdateDepartement(data:Departement){
    
    data.idDepart=this.id;

    this.service.UpdateDepartement(data).subscribe(()=>{},(error)=>{console.log(error);})
    this.router.navigateByUrl("departement/DepartementHome/detail/"+this.id);
    
  }
  

}
