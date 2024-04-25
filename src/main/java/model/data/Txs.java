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
public class Txs {
  @JsonProperty
  private String txid;
  @JsonProperty(value = "amounts_received")
  private List<Amounts> amountsReceived;
  @JsonProperty
  private List<String> senders;
  @JsonProperty(value = "available_balance")
  private String availableBalance;
}
