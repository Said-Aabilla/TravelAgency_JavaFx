package sample.model;

public class place_bus {

	private int id_pb;
	private int num_cp;
	private int id_bus;
	public place_bus() {
	}
	public place_bus(int id_pb, int num_cp, int id_bus) {
		this.id_pb = id_pb;
		this.num_cp = num_cp;
		this.id_bus = id_bus;
	}
	public int getId_pb() {
		return id_pb;
	}
	public void setId_pb(int id_pb) {
		this.id_pb = id_pb;
	}
	public int getNum_cp() {
		return num_cp;
	}
	public void setNum_cp(int num_cp) {
		this.num_cp = num_cp;
	}
	public int getId_bus() {
		return id_bus;
	}
	public void setId_bus(int id_bus) {
		this.id_bus = id_bus;
	}

	
}
