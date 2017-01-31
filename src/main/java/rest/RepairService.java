package rest;

import dao.IRepositoryCatalog;
import domain.Repair;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import rest.dto.RepairDto;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Path("repairs")
@Stateless
public class RepairService {
    IRepositoryCatalog catalog;
    Mapper mapper = new DozerBeanMapper();

    @PersistenceContext
    EntityManager mgr;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<RepairDto> getAll() throws SQLException {

        List<Repair> repairs =  mgr.createNamedQuery("repair.all", Repair.class).getResultList();
        List<RepairDto> results = new ArrayList<RepairDto>();
        for(Repair r: repairs)
            results.add(mapper.map(r, RepairDto.class));

        return results;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRepair(@PathParam("id") int repairId){
        Repair r = mgr.createNamedQuery("repair.id", Repair.class)
                .setParameter("repairId",repairId)
                .getSingleResult();
        if(r==null)
            return Response.status(404).build();

        return	Response.ok(mapper.map(r, RepairDto.class)).build();
    }
}
