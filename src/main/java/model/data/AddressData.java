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
public class AddressData {
  @JsonProperty
  private String network;
  @JsonProperty
  private Integer user_id;
  @JsonProperty
  private String address;
  @JsonProperty
  private String label;
}
