package org.firstinspires.frc.framework.hardware;

import java.util.InputMismatchException;

/**
 * Represents a physical port on the RoboRIO.
 * @author FRC 4739 Thunderbolts Robotics
 * @version 2016-07-20/00
 */
public enum RioHWPort {
	PWM_0(PortType.PWM, 0), PWM_1(PortType.PWM, 1), PWM_2(PortType.PWM, 2), PWM_3(PortType.PWM, 3), PWM_4(PortType.PWM, 4), PWM_5(PortType.PWM, 5), PWM_6(PortType.PWM, 6), PWM_7(PortType.PWM, 7), PWM_8(PortType.PWM, 8), PWM_9(PortType.PWM, 9);

	public enum PortType {
		PWM
	}

	private final int index;
	private final PortType type;
	@SuppressWarnings("SameParameterValue")
	RioHWPort(PortType t, int i) {
		index = i;
		type = t;
	}
	public int getIndex() {
		return index;
	}
	public PortType getType() {
		return type;
	}

	public static final class MismatchedRioPortException extends InputMismatchException {
		/**
		 * @param target Expected port type
		 * @param given Incorrect port type which was passed
		 */
		@SuppressWarnings("SameParameterValue")
		public MismatchedRioPortException(PortType target, PortType given) {
			super("Required PortType." + target.name() + ", PortType." + given.name() + " given");
		}
	}
}
