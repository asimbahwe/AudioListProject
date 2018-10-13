package africa.lejournal.audiolistproject;

public class AudioModel {
    private String name,creationDate,singer;

    public AudioModel() {
    }

    public AudioModel(String name, String creationDate, String singer) {
        this.name = name;
        this.creationDate = creationDate;
        this.singer = singer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }
}
