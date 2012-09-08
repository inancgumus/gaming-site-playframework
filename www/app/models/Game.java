package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;
import play.data.validation.*;

@Entity
public class Game extends Model {
    @Required public String 
        name;
    @Lob @MaxSize(32768) public String 
        description;
    @Required public String 
        gamePath;
    @Lob @MaxSize(32768) public String 
        playingTips;
    @Lob @MaxSize(32768) public String 
        playingKeys;
    @Required public String 
        thumbnailPath;
    @Required public String 
        largeThumbnailPath;
    
    public Date addedAt;
    
    public Game(String name, String description, String gamePath) {
        this.name = name;
        this.description = description;
        this.gamePath = gamePath;
    }

    public String toString() {
        return name;
    }

	public final String nameUrlEncoded() {
		return name.replace(' ', '+');
	}

    public final static Game random() {
        // only works w/mysql and postgresql
        return (Game) find("order by rand()").fetch(1).get(0);
    }

    public final static Game randomBut(String currentSelectedGame) {
        // only works w/mysql and postgresql
        return (Game) find("name is not ? order by rand()",
            currentSelectedGame).fetch(1).get(0);
    }
}
