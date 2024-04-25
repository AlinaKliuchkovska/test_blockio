package model.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class Outputs {
  @JsonProperty(value = "output_value")
  private String transactionAmount;
  @JsonProperty(value = "receiving_address")
  private String transactionRecipient;
}
