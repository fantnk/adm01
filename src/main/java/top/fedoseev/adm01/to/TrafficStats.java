package top.fedoseev.adm01.to;

import java.time.LocalDateTime;

public class TrafficStats {
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final long subscriber;
    private long bytesTransferred;
    private float speed;
    private final LinkType linkType;

    public TrafficStats(LocalDateTime startDate, LocalDateTime endDate, long subscriber, LinkType linkType) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.subscriber = subscriber;
        this.linkType = linkType;
    }

    public enum LinkType {
        UPLINK,
        DOWNLINK
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public long getSubscriber() {
        return subscriber;
    }

    public long getBytesTransferred() {
        return bytesTransferred;
    }

    public void setBytesTransferred(long bytesTransferred) {
        this.bytesTransferred = bytesTransferred;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public LinkType getLinkType() {
        return linkType;
    }

    /*public void setLinkType(LinkType linkType) {
        this.linkType = linkType;
    }*/

    @Override
    public String toString() {
        return "TrafficStat{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", subscriber=" + subscriber +
                ", bytesTransferred=" + bytesTransferred +
                ", speed=" + speed +
                ", linkType=" + linkType +
                '}';
    }
}
