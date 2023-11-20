package org.example.user;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "T_users")
public class User  {
    @Id
    private Integer uid;
    private String u_name;
    public UserRole u_role;

}
