package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import model.data.PrerareTransactionData;

@Data
@Getter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class PrepareTransaction {
  @JsonProperty
  private String status;
  @JsonProperty
  private PrerareTransactionData data;
}
