package Run;

import Control.MyControl;
import Model.MyModel;
import View.MyView;

public class Run {
	public static void main(String[] args) {
		MyModel model = new MyModel();
		MyView view = new MyView();
		MyControl control = new MyControl(model, view);
		
	}
}
