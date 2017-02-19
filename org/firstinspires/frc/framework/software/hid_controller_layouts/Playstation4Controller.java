package org.firstinspires.frc.framework.software.hid_controller_layouts;

import edu.wpi.first.wpilibj.Joystick;
import org.firstinspires.frc.framework.abstraction.DSGamepadIndex;
import org.firstinspires.frc.framework.software.HIDControllerLayout;

/**
 * Official controller for Sony's social game console, the Playstation 4.
 * @author FRC 4739 Thunderbolts Robotics
 * @version 2017-02-19/00
 */
@SuppressWarnings("unused")
public class Playstation4Controller extends HIDControllerLayout {
	public enum Axes {
		LX(0), LY(1), RX(2), RY(5),
		L2(3), R2(4);

		private final int value;
		Axes(int i) {
			value = i;
		}
		public int getValue() {
			return value;
		}
	}

	public enum Buttons {
		CROSS(2), CIRCLE(3), SQUARE(1), TRIANGLE(4),
		L1(5), R1(6),
		L2(7), R2(8),
		L3(11), R3(12),
		SHARE(9), OPTIONS(10), PS(13),
		TOUCHPAD(14),

		X(1), O(2);

		private final int value;
		Buttons(int i) {
			value = i;
		}
		public int getValue() {
			return value;
		}
	}

	private DSGamepadIndex index;
	private Joystick rawJoystick;

	public Playstation3Controller(DSGamepadIndex i) {
		super(i);
	}

	/**
	 * Get the position or slider value of some axis on this controller.
	 * Note: the Analog Sticks have (1.0, 1.0) in the bottom-right corner.
	 * Note: the Triggers rest at 0.5 and go to 1.0 (TODO: check this)
	 * @param a Axis to return the value of
	 * @return Value of axis a
	 */
	public double getAxis(Axes a) {
		return rawJoystick.getRawAxis(a.getValue());
	}

	/**
	 * Get the pressed state of some button on this controller.
	 * Note: the Guide button is disabled, and will remain disabled until either FIRST's DS supports it or they officially endorse another DS.
	 * @param b Button to return the state of
	 * @return True if pressed, false if not pressed or exception thrown
	 */
	public boolean getButton(Buttons b) {
		return rawJoystick.getRawButton(b.getValue());
	}

	/**
	 * Get the index (assigned by the DS) of this controller.
	 * @return Index of this controller
	 */
	public DSGamepadIndex getIndex() {
		return index;
	}

	public POVDirection getPOVDirection() {
		return POVDirection.parseInt(rawJoystick.getPOV());
	}
}
