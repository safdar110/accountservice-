package com.itechneer.rasservproj.controller;

//@RestController
public class UserController {




 // Working Code

    /*@Autowired
    UserRepository repository;
      */

    /*
    @GetMapping("/bulkcreate")
    public String bulkcreate(){
        // save a single User
        repository.save(new User("Tanveer", "1234", "tanveer@sct.com"));

        // save a list of Users
        repository.saveAll(Arrays.asList(new User("Ali", "Khan", "ali@sct.com")
                , new User("Salim", "12345", "salim@sct.com")
                , new User("Rahil", "4321","rahil@sct.com")
                , new User("Faiz", "6543", "faiz@sct.com")));

        return "Users are created";
    }
     */

   /* @PostMapping("/create")
    public String create(@RequestBody UserUI user){
        // save a single User
         repository.save(new User(user.getName(), user.getPassword(), user.getEmail()));
        //repository.save(new User("Tanveer", "654123987", "tanveer@sct.com"));

        return "User is created";
    }
    @GetMapping("/findall")
    public List<UserUI> findAll(){

        List<User> users = repository.findAll();
        List<UserUI> userUI = new ArrayList<>();

        for (User user : users) {
            userUI.add(new UserUI(user.getName(),user.getPassword(), user.getEmail()));
        }

        return userUI;
    }

    @RequestMapping("/search/{id}")
    public String search(@PathVariable long id){
        String user = "";
        user = repository.findById(id).toString();
        return user;
    }

    @RequestMapping("/searchbyname/{name}")
    public List<UserUI> fetchDataByName(@PathVariable String name){

        List<User> users = repository.findByName(name);
        List<UserUI> userUI = new ArrayList<>();

        for (User user : users) {
            userUI.add(new UserUI(user.getName(), user.getPassword(), user.getEmail()));
        }

        return userUI;
    } */
}
