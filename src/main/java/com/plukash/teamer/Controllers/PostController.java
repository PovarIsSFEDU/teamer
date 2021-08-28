package com.plukash.teamer.Controllers;


import com.plukash.teamer.DAO.TeamDAO;
import com.plukash.teamer.DAO.UserDAO;
import com.plukash.teamer.Entities.Comp;
import com.plukash.teamer.Entities.User;
import com.plukash.teamer.Utility.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.*;

@RestController
@CrossOrigin
public class PostController {

    @Autowired
    TeamDAO teamDAO;
    @Autowired
    UserDAO userDAO;


    @PostMapping("/createTeam")
    public Response CreateTeam() {

        return new Response(true);
    }

    @PostMapping("/deleteTeam")
    public Response DeleteTeam() {
        return new Response(true);
    }

    @GetMapping("/autoGen/{capt_id}")
    @Transactional
    public Response AutoGenerateTeam(HttpServletRequest request, @PathVariable long capt_id) {
        try {
            User captain = userDAO.findById(capt_id).get();
            Set<Comp> comp = captain.getCompetentions();
            Comp cap_comp[] = new Comp[comp.size()];
            cap_comp = comp.toArray(cap_comp);
            List<User> add_users = new ArrayList<>();
            User u1 = new User();
            User u2 = new User();
            switch (cap_comp[0].getOp()) {
                case "Angular", "Vue":
                    u1 = userDAO.GetBack().get(0);
                    u2 = userDAO.GetDesign().get(0);
                    userDAO.SetInTeam(u1.getId());
                    userDAO.SetInTeam(u2.getId());
                    add_users.add(u1);
                    add_users.add(u2);
                    break;
                case "Django", "Java", "C#", "C/C++":
                    u1 = userDAO.GetFront().get(0);
                    u2 = userDAO.GetDesign().get(0);
                    userDAO.SetInTeam(u1.getId());
                    userDAO.SetInTeam(u2.getId());
                    add_users.add(u1);
                    add_users.add(u2);
                    break;
                case "Figma", "Sketch", "Разработка UX/UI":
                    u1 = userDAO.GetFront().get(0);
                    u2 = userDAO.GetBack().get(0);
                    userDAO.SetInTeam(u1.getId());
                    userDAO.SetInTeam(u2.getId());
                    add_users.add(userDAO.GetFront().get(0));
                    add_users.add(userDAO.GetBack().get(0));
                    break;
                case "Unreal Engine", "Unity 3D":
                case "Project Management", "Product Management", "Гибкие методологии управления проектами ", "Аналитика бизнес-процессов":
                case "Machine Learning", "Теория машинного обучения":
                    break;
            }
            Random r = new Random();

            Generate(capt_id, add_users, 3, (long) r.nextInt(100));
            userDAO.SetInTeam(capt_id);
            return new Response(true, add_users.get(0).getTGusername(), add_users.get(1).getTGusername());

        } catch (Exception e) {
            e.printStackTrace();
            return new Response(false);
        }

    }


    void Generate(long id, List<User> add_users, int count, long id2) {
        switch (count) {
            case 5 -> teamDAO.Gen5(id, add_users.get(0).getId(), add_users.get(1).getId(), add_users.get(2).getId(), add_users.get(3).getId());
            case 4 -> teamDAO.Gen4(id, add_users.get(0).getId(), add_users.get(1).getId(), add_users.get(2).getId());
            case 3 -> teamDAO.Gen3(id, add_users.get(0).getId(), add_users.get(1).getId(), id2);
        }
    }
}
