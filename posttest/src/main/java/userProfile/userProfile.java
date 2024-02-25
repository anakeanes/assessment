package userProfile;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "userProfile")
public class userProfile {

    @Id
    private String user_Id;

    private String name;

    private  String user_email;

    private  String user_Password;

    @OneToMany(mappedBy = "userProfile")
    private List<userProfile> user_id;


}
