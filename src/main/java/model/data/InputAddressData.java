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
public class InputAddressData {
  @JsonProperty(value="required_signatures")
  private String requiredSignatures;
  @JsonProperty(value="public_keys")
  private List<String> publicKeys;
}
