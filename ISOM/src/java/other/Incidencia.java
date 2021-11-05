package other;

/**
 *
 * @author evilmonkey19
 */
import java.util.Date;
import lombok.Data;

public @Data class Incidencia {
    private final String centre;
    private final String carrer;
    private final String causa;
    private final String relevancia;
    private final String descripcio;
    private final Date data;
    
    public int toDDBB(){
        return 0;
    }
}
