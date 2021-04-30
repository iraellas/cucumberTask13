package models;

import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SearchRequestBody {
    String searchText;
    String searchInput;
    String searchButton;
    String titleResult;
}
