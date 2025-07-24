package quiz_App_Service.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDto {

    private String Id;

    private String title;

    private String description;

    private boolean active;
}