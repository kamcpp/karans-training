package co.karans.session27.services.rs;

import co.karans.session26.ejbs.Book;
import co.karans.session26.ejbs.BookLocal;

import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;

@Path("/book")
public class BookRSService {

    @EJB
    private BookLocal bookEJB;

    @GET
    @Produces("application/json")
    public JsonObject getAll() {
        return Json.createObjectBuilder().add("message", "hello world!").build();
    }

    @PUT
    @Produces("application/json")
    public JsonObject save(@QueryParam("name") String name, @QueryParam("py") Integer publishYear) {
        long id = bookEJB.save(new Book(name, publishYear));
        return Json.createObjectBuilder().add("id", id).build();
    }
}
