package ir.co.isc.software.angulartraining.rs;

import ir.co.isc.software.angulartraining.entity.Employee;
import ir.co.isc.software.angulartraining.service.EmployeeService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 *  *
 *  * @author V_Alahvakil
 *    CreateDateTime 11/8/2018
 *  
 */
@Path("/employee")
@Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
@Consumes({MediaType.APPLICATION_JSON})
public class EmployeeRestService {

    @Inject
    EmployeeService employeeService;

    @GET
    @Path("test")
    public Response test(){
        return Response.ok("OK").build();
    }


    @GET
    @Path("get/{id}")
    public Response getEmployee(
            @PathParam("id")
                    Long employeeId) {
        Employee employee = employeeService.getEmployee(employeeId);
        if (employee == null ) {
            return Response.status(404).build();
        } else {
            return Response.ok(employee).build();
        }

    }

    @GET
    @Path("all")
    public Response getEmployees( @QueryParam("page") String page,@QueryParam("pageSize") String pageSize){
        if(pageSize==null || pageSize.trim().isEmpty())
            pageSize="10";
        if(page==null || page.trim().isEmpty())
            page="1";
        List<Employee> lstEmployee= employeeService.getEmployees(Integer.parseInt(page),Integer.parseInt(pageSize));
        return Response.ok(lstEmployee).build();


    }

    @POST
    @Path("save")
    public Response saveEmployee(Employee employee){
        if(employeeService.save(employee))
            return Response.ok().build();
        else
            return Response.serverError().build();

    }
}
