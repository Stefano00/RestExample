# RestExample
## A simple example of a rest application

#### In this project, you will see how create a service Rest with Java, Spring and JPA. 

## Starting 🚀

In [Spring initializr](https://start.spring.io/), you have to add the following dependencies:
* Spring web
* JPA
* MySQL (if you use MySQL)
* Lombok (Optional)
* Spring DevTool (to refresh automatically)

This example is about a veterinarian service that you can registrer a pet.
To do this, is necessary use in the controller the annotation **@RestController** with a get and post method.
The **GET** method is to list the pets. The **POST** method is to create a pet.

```
@RestController
@CrossOrigin
@RequestMapping("/api/v1/pet")
public class PetController {

	@Autowired
	IPetService petService;
	
	@GetMapping("/all")
	@ResponseStatus(HttpStatus.OK)
	public List<Pet> findAll() {
		return petService.findAll();
	}
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody Pet pet) {
		petService.createPet(pet);
	}
}
```

The repository with the Crud (Create Read Update and delete) is the basic, whithout annother methods. 📖
```
@Repository
public interface IPetRepository extends CrudRepository<Pet, Integer>{
	
}
```

Our Class in the model is only with the object Pet 😾
```
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="pet")
public class Pet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String tipo;
	private String dueno;
	private String detalle;
	private String estado;
}
```
**@Data, @NoArgsConstructor and @AllArgsConstructor** is from Lombok dependency to generate Getter, Setter and constructor

And to terminate this project, the **@Service** in the ServiceImpl (create an Interface with methods) we calls the methos to the CRUD ⭐
```
@Service
public class PetServiceImpl implements IPetService {

	@Autowired
	IPetRepository petRepository;
	
	@Override
	public void createPet(Pet pet) {
		petRepository.save(pet);
	}

	@Override
	public List<Pet> findAll() {
		return (List<Pet>) petRepository.findAll();
	}

}
```

And done!
if we want to create a pet, with postman you can send with post method this JSON 😎
```
http://localhost:8080/api/v1/pet/create
```
```
{
  "nombre":"DIARIO",
  "tipo":"GATO",
  "dueno": "953354981",
  "detalle":"CONTROL",
  "estado":"EN_PROCESO"
}
```

and if we call the pets, with a get method we can do it! 😎😎😎
```
http://localhost:8080/api/v1/pet/create
```
and we are going to receive
```
[
    {
        "id": 1,
        "nombre": "DIARIO",
        "tipo": "GATO",
        "dueno": "953354981",
        "detalle": "CONTROL",
        "estado": "EN_PROCESO"
    }
]
```
