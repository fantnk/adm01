package top.fedoseev.adm01.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.fedoseev.adm01.model.Traffic;

import java.util.List;

@RestController
@RequestMapping("/ajax/traffic")
public class TrafficAjaxController extends AbstractTrafficController {

    @Override
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Traffic> getAll() {
        return super.getAll();
    }

    /*@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }*/

}
