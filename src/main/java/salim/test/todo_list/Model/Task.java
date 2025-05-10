package salim.test.todo_list.Model;
import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity 
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType. IDENTITY)
    private Long id;
    private String titre;
    private String description;
    @Enumerated(EnumType.STRING)
    private Statut statut;
    private LocalDateTime dateCreation;
    private LocalDateTime dataEcheance;
    @PrePersist
    public void prePersist() {
    dateCreation = LocalDateTime.now();
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Statut getStatut() { return statut; }
    public void setStatut(Statut statut) { this.statut = statut; }


}
