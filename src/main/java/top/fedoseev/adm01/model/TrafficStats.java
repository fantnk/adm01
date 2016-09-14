package top.fedoseev.adm01.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Access(AccessType.FIELD)
//@Table(name = "trafficStats")
public class TrafficStats {
    @Id
    @GeneratedValue
    protected Integer id;

    @Column(name = "fromdate")
    private LocalDateTime fromDate;

    @Column(name = "todate")
    private LocalDateTime toDate;

    @Column(name = "subscriber")
    private long subscriber;

    @Column(name = "bytestransferred")
    private long bytesTransferred;

    /*@Column(name = "linkType", nullable = false)
    private LinkType linkType;*/

    public enum LinkType {
        UPLINK,
        DOWNLINK
    }

    public TrafficStats() {
        System.out.println();
    }

    public TrafficStats(long a) {
        System.out.println(a);
    }

    public TrafficStats(long a, long b, long c, long d) {
        System.out.println(a);
    }

    public TrafficStats(LocalDateTime fromDate, LocalDateTime toDate, long subscriber, long bytesTransferred) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.subscriber = subscriber;
        this.bytesTransferred = bytesTransferred;
    }

    public TrafficStats(LocalDateTime fromDate, LocalDateTime toDate, long subscriber) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.subscriber = subscriber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDateTime fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDateTime getToDate() {
        return toDate;
    }

    public void setToDate(LocalDateTime toDate) {
        this.toDate = toDate;
    }

    public long getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(long subscriber) {
        this.subscriber = subscriber;
    }

    public long getBytesTransferred() {
        return bytesTransferred;
    }

    public void setBytesTransferred(long bytesTransferred) {
        this.bytesTransferred = bytesTransferred;
    }

    /*public LinkType getLinkType() {
        return linkType;
    }

    public void setLinkType(LinkType linkType) {
        this.linkType = linkType;
    }*/

    @Override
    public String toString() {
        return "TrafficStats{" +
                "id=" + id +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", subscriber=" + subscriber +
                ", bytesTransferred=" + bytesTransferred +
//                ", linkType=" + linkType +
                '}';
    }
}
