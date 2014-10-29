
public class Quest {
	private int totalCargo, cargoleft;
	private String id, target;
	
	public Quest(String id, String target, int totalCargo){
		this.id = id;
		this.target = target;
		this.totalCargo = totalCargo;
		this.cargoleft = totalCargo;}

	public int getCargoleft() {
		return cargoleft;
	}

	public void setCargoleft(int cargoleft) {
		this.cargoleft = cargoleft;
	}

	public int getTotalCargo() {
		return totalCargo;
	}

	public String getId() {
		return id;
	}

	public String getTarget() {
		return target;
	}
	
}
