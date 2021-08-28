package com.plukash.teamer.Utility;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.jdbc.core.metadata.HsqlTableMetaDataProvider;

@AllArgsConstructor
@NoArgsConstructor
public class Response {
    @Getter
    @Setter
    private boolean status;

    @Getter
    @Setter
    private long team_id;

    @Getter
    @Setter
    private String p1TG;
    @Getter
    @Setter
    private String p2TG;
    @Getter
    @Setter
    private String p3TG;
    @Getter
    @Setter
    private String p4TG;


    public Response(boolean status) {
        this.status = status;
    }

    public Response(boolean b, String tGusername, String tGusername1) {
        this.status = b;
        this.p1TG = tGusername;
        this.p2TG = tGusername1;
    }
}
