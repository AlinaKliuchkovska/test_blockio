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
public class PrerareTransactionData {
  @JsonProperty
  private String network;
  @JsonProperty(value = "tx_type")
  private String transactionType;
  @JsonProperty
  private List<Outputs> outputs;
  @JsonProperty(value="input_address_data")
  private List<InputAddressData> inputAddressData;
  @JsonProperty
  private UserKey userKey;
  @JsonProperty(value="expected_unsigned_txid")
  private String transactionId;
}
