package automatic.irrigation.system.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"status", "reasonText"})
@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class PlotException extends Exception {
    private static final long serialVersionUID = 1L;

    @JsonProperty("reasonText")
    private String reasonText;

    @JsonProperty("status")
    private String status;

    public PlotException(String errorMessage) {
        super(errorMessage);
    }


    public PlotException(String status, String reasonText) {
        super(reasonText);
        this.status = status;
        this.reasonText = reasonText;
    }

    public PlotException withReasonText(String reasonText) {
        this.reasonText = reasonText;
        return this;
    }

    public PlotException withStatus(String status) {
        this.status = status;
        return this;
    }

}
