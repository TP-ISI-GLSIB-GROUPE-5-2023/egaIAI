@Entity
public class Compte{

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String numero;

    private String type;

    private LocalDate dateCreation;

    private BigDecimal solde;

    @ManyToOne
    private Client proprietaire;



}