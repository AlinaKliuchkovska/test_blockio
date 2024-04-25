package model.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;
@Data
@Getter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class BalanceData {
  @JsonProperty
  private String network;
  @JsonProperty(value = "available_balance")
  private String availableBalance;
  @JsonProperty
  private List<Balances> balances;
}
