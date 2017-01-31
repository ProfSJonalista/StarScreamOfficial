package rest;

import dao.IRepositoryCatalog;
import domain.Profile;
import domain.Repair;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import rest.dto.ProfileDto;
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
import java.util.ArrayList;
import java.util.List;

@Path("profiles")
@Stateless
public class ProfileService {
	IRepositoryCatalog catalog;
	Mapper mapper = new DozerBeanMapper();

	@PersistenceContext
	EntityManager mgr;


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProfileDto> getAll(){
		List<Profile> profiles =  mgr.createNamedQuery("profile.all", Profile.class).getResultList();
		List<ProfileDto> results = new ArrayList<ProfileDto>();
		for(Profile p: profiles)
			results.add(mapper.map(p, ProfileDto.class));
		return results;
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProfile(@PathParam("id") int profileId){
		Profile p = mgr.createNamedQuery("profile.id", Profile.class)
				.setParameter("profileId",profileId)
				.getSingleResult();
		if(p==null)
			return Response.status(404).build();

		return	Response.ok(mapper.map(p, ProfileDto.class)).build();
	}


	@GET
	@Path("/{id}/repairs")
	@Produces(MediaType.APPLICATION_JSON)
	public List<RepairDto> getPersonAccounts(@PathParam("id") int profileId){
		Profile p = mgr.createNamedQuery("profile.id", Profile.class)
				.setParameter("profileId",profileId)
				.getSingleResult();
		if(p==null)
			return null;
		List<RepairDto> result = new ArrayList<RepairDto>();
		for(Repair r: p.getDevicesInRepair()){
			result.add(mapper.map(r, RepairDto.class));
		}
		return result;
	}
}






























