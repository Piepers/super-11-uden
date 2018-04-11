package me.piepers.super11.domain.sportdeer;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

/**
 * A type of event that describes a goal
 *
 * @author Bas Piepers (bas@piepers.me)
 */
@DataObject
public class Goal {
    @JsonProperty("goal_subtype")
    private String subType;
    @JsonProperty("goal_type_code")
    private String typeCode;
    @JsonProperty("goal_type_desc")
    private String typeDesc;

    public Goal(@JsonProperty("goal_subtype") String subType, @JsonProperty("goal_type_code") String typeCode, @JsonProperty("goal_type_desc") String typeDesc) {
        this.subType = subType;
        this.typeCode = typeCode;
        this.typeDesc = typeDesc;
    }

    public Goal(JsonObject jsonObject) {
        this.subType = jsonObject.getString("goal_subtype");
        this.typeCode = jsonObject.getString("goal_type_code");
        this.typeDesc = jsonObject.getString("goal_type_desc");
    }

    public String getSubType() {
        return subType;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    @Override
    public String toString() {
        return "Goal{" +
                "subType='" + subType + '\'' +
                ", typeCode='" + typeCode + '\'' +
                ", typeDesc='" + typeDesc + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Goal goal = (Goal) o;

        if (!subType.equals(goal.subType)) return false;
        if (!typeCode.equals(goal.typeCode)) return false;
        return typeDesc.equals(goal.typeDesc);
    }

    @Override
    public int hashCode() {
        int result = subType.hashCode();
        result = 31 * result + typeCode.hashCode();
        result = 31 * result + typeDesc.hashCode();
        return result;
    }
}
