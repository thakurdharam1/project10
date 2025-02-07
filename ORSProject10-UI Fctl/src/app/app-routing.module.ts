
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { MarksheetComponent } from './marksheet/marksheet.component';
import { StudentComponent } from './student/student.component';
import { CollegeComponent } from './college/college.component';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ForgotPasswordComponent } from './login/forgotpassword.component';
import { SignUpComponent } from './login/signup.component';
import { MessageComponent } from './message/message.component';
import { MessageListComponent } from './message/message-list.component';
import { MarksheetListComponent } from './marksheet/marksheet-list.component';
import { CollegeListComponent } from './college/college-list.component';
import { StudentListComponent } from './student/student-list.component';
import { UserListComponent } from './user/user-list.component';
import { UserComponent } from './user/user.component';
import {RoleComponent } from './role/role.component';
import { CourseComponent } from "./course/course.component";
import {SubjectComponent }  from "./subject/subject.component"
import { Subject, from } from 'rxjs';
import { RoleListComponent } from './role/role-list.component';
import { CourseListComponent } from "./course/course-list.component";
import {  FacultyComponent} from "./faculty/faculty.component";
import {  FacultyListComponent} from "./faculty/faculty-list.component";
import { TimetableComponent } from "./timetable/timetable.component";
import { FileComponent } from './file/file.component';
import { TimetableListComponent } from './timetable/timetable-list.component';
import { SubjectListComponent } from './subject/subject-list.component';
import { MarksheetmeritListComponent } from "./marksheet/marksheetmerit-list.component";
import { GetmarksheetComponent } from "./marksheet/getmarksheet.component";
import { ChangepasswordComponent } from "./user/changepassword.component";
import { LoaderComponent } from './loader/loader.component';
import { SpinnerComponent} from './spinner/spinner.component';
import {MyprofileComponent} from './user/myprofile.component';

import { AssetComponent } from './asset/asset.component';
import { AssetListComponent } from './asset/assetlist.component';
import { CustomerComponent } from './customer/customer.component';
import { CustomerlistComponent } from './customer/customerlist.component';
import { EmployeeComponent } from './employee/employee.component';
import { EmployeelistComponent } from './employee/employeelist.component';
import { CartComponent } from './cart/cart.component';
import { CartlistComponent } from './cart/cartlist.component';
import { AbcComponent } from './abc/abc.component';
import { AbclistComponent } from './abc/abclist.component';
import { VehicleComponent } from './vehicle/vehicle.component';
import { VehiclelistComponent } from './vehicle/vehiclelist.component';
import { XyzComponent } from './xyz/xyz.component';
import { XyzlistComponent } from './xyz/xyzlist.component';
import { BankComponent } from './bank/bank.component';
import { BanklistComponent } from './bank/banklist.component';


const routes: Routes = [
    {
        path: '',
        redirectTo: 'dashboard',
        pathMatch: 'full'
    },
    {
        path: 'dashboard',
        component: DashboardComponent
    },
    {
        path: 'loader',
        component : LoaderComponent

    },
    {
        path: 'login',
        component: LoginComponent
    }
    ,
    {
        path: 'login/:userparams',
        component: LoginComponent
    },
   
    {
        path: 'spinner',
        component: SpinnerComponent
    },
    {
        path: 'forgotpassword',
        component: ForgotPasswordComponent
    },
    {
        path: 'signup',
        component: SignUpComponent
    },
    {
        path: 'message',
        component: MessageComponent,
      
    },
    {
        path: 'message/:id',
        component: MessageComponent
    },
    {
        path: 'messagelist',
        component: MessageListComponent
      
    },
    {
        path: 'marksheet',
        component: MarksheetComponent
      
    },
    {
        path: 'marksheet/:id',
        component: MarksheetComponent
      
    },
    {
        path: 'marksheetlist',
        component: MarksheetListComponent
      
    },
    {
        path: 'marksheetmeritlist',
        component: MarksheetmeritListComponent
      
    },
    {
        path: 'getmarksheet',
        component : GetmarksheetComponent
      
    },
    {
        path: 'college',
        component: CollegeComponent
      
    },
    {
        path: 'college/:id',
        component: CollegeComponent
      
    },
    {
        path: 'collegelist',
        component: CollegeListComponent
      
    },
    {
        path: 'student',
        component: StudentComponent
      
    },
    {
        path: 'student/:id',
        component: StudentComponent
      
    },
    {
        path: 'studentlist',
        component: StudentListComponent
      
    },
    {
        path: 'user',
        component: UserComponent
      
    },
    {
        path: 'user/:id',
        component: UserComponent
      
    },
    {
        path: 'userlist',
        component: UserListComponent
      
    },
    {
        path: 'role',
        component : RoleComponent
      
    },
    {
        path : 'rolelist',
        component : RoleListComponent
      
    },
    {
        path: 'role/:id',
        component: RoleComponent
      
    },
    {
        path: 'course',
        component: CourseComponent
      
    },
    {
        path: 'courselist',
        component: CourseListComponent
      
    },
    {
        path :'course/:id',
        component :CourseComponent
      
    },
    {

        path:'faculty',
        component:FacultyComponent
      
    },
    {
        path : 'facultylist',
        component : FacultyListComponent
      
    },
    {
        path : 'faculty/:id',
        component : FacultyComponent
      
    },
    {
        path: 'timetable',
        component : TimetableComponent
      

    },
    {
        path:'timetablelist',
        component: TimetableListComponent
      
    },
    {
        path : 'timetable/:id',
        component : TimetableComponent
      
    },
    {
        path: 'subject',
        component: SubjectComponent
      
    },
    {
        path: 'subjectlist',
        component : SubjectListComponent
      
    },
    {
        path : 'subject/:id',
        component : SubjectComponent
      
    },
    {
        path : 'myprofile',
        component: MyprofileComponent
    },
    {
        path: 'file',
        component: FileComponent
    },
    {   path :'changepassword',
        component : ChangepasswordComponent
      
    }, 
    {
        path: 'asset',
        component: AssetComponent
      },
      {
        path: 'assetlist',
        component: AssetListComponent
      },
      {
        path: 'asset/:id',
        component: AssetComponent
      },
      {
        path:'customer',
        component:CustomerComponent
      },
       {
        path:'customerlist',
        component:CustomerlistComponent
      },
      {
        path: 'employee',
        component: EmployeeComponent
      
    },
    {
        path: 'employee/:id',
        component: EmployeeComponent
      
    },
    {
        path: 'employeelist',
        component: EmployeelistComponent
      
    },
    {
        path: 'cart',
        component: CartComponent
      
    },
    {
        path: 'cart/:id',
        component: CartComponent
      
    },
    {
        path: 'cartlist',
        component: CartlistComponent
      
    },
    {
        path: 'abc',
        component: AbcComponent
      
    },
    {
        path: 'abc/:id',
        component: AbcComponent
      
    },
    {
        path: 'abclist',
        component: AbclistComponent
      
    },
    {
        path: 'vehicle',
        component: VehicleComponent
      
    },
    {
        path: 'vehicle/:id',
        component: VehicleComponent
      
    },
    {
        path: 'vehiclelist',
        component: VehiclelistComponent
      
    },
    {
        path: 'xyz',
        component: XyzComponent
      
    },
    {
        path: 'xyz/:id',
        component: XyzComponent
      
    },
    {
        path: 'xyzlist',
        component: XyzlistComponent
      
    },
    {
        path: 'bank',
        component: BankComponent
      
    },
    {
        path: 'bank/:id',
        component: BankComponent
      
    },
    {
        path: 'banklist',
        component: BanklistComponent
      
    },
  
      
    
];

@NgModule({
    imports: [RouterModule.forRoot(routes,{useHash:true})],
    exports: [RouterModule]
})


export class AppRoutingModule { }