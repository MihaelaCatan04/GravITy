package gen;

// Generated from C:/Users/ionvo/OneDrive/Desktop/DSL_I/src/main/antlr4/MyDSL.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MyDSLParser}.
 */
public interface MyDSLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#simulation}.
	 * @param ctx the parse tree
	 */
	void enterSimulation(MyDSLParser.SimulationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#simulation}.
	 * @param ctx the parse tree
	 */
	void exitSimulation(MyDSLParser.SimulationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#simulation_body}.
	 * @param ctx the parse tree
	 */
	void enterSimulation_body(MyDSLParser.Simulation_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#simulation_body}.
	 * @param ctx the parse tree
	 */
	void exitSimulation_body(MyDSLParser.Simulation_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#physics_module}.
	 * @param ctx the parse tree
	 */
	void enterPhysics_module(MyDSLParser.Physics_moduleContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#physics_module}.
	 * @param ctx the parse tree
	 */
	void exitPhysics_module(MyDSLParser.Physics_moduleContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#collision}.
	 * @param ctx the parse tree
	 */
	void enterCollision(MyDSLParser.CollisionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#collision}.
	 * @param ctx the parse tree
	 */
	void exitCollision(MyDSLParser.CollisionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#movers_list}.
	 * @param ctx the parse tree
	 */
	void enterMovers_list(MyDSLParser.Movers_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#movers_list}.
	 * @param ctx the parse tree
	 */
	void exitMovers_list(MyDSLParser.Movers_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#mover}.
	 * @param ctx the parse tree
	 */
	void enterMover(MyDSLParser.MoverContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#mover}.
	 * @param ctx the parse tree
	 */
	void exitMover(MyDSLParser.MoverContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#mover_properties}.
	 * @param ctx the parse tree
	 */
	void enterMover_properties(MyDSLParser.Mover_propertiesContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#mover_properties}.
	 * @param ctx the parse tree
	 */
	void exitMover_properties(MyDSLParser.Mover_propertiesContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#electrostatic_field}.
	 * @param ctx the parse tree
	 */
	void enterElectrostatic_field(MyDSLParser.Electrostatic_fieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#electrostatic_field}.
	 * @param ctx the parse tree
	 */
	void exitElectrostatic_field(MyDSLParser.Electrostatic_fieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#particle_radius_expr}.
	 * @param ctx the parse tree
	 */
	void enterParticle_radius_expr(MyDSLParser.Particle_radius_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#particle_radius_expr}.
	 * @param ctx the parse tree
	 */
	void exitParticle_radius_expr(MyDSLParser.Particle_radius_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#flux_resolution_expr}.
	 * @param ctx the parse tree
	 */
	void enterFlux_resolution_expr(MyDSLParser.Flux_resolution_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#flux_resolution_expr}.
	 * @param ctx the parse tree
	 */
	void exitFlux_resolution_expr(MyDSLParser.Flux_resolution_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#drag_force}.
	 * @param ctx the parse tree
	 */
	void enterDrag_force(MyDSLParser.Drag_forceContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#drag_force}.
	 * @param ctx the parse tree
	 */
	void exitDrag_force(MyDSLParser.Drag_forceContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#mover_color_expr}.
	 * @param ctx the parse tree
	 */
	void enterMover_color_expr(MyDSLParser.Mover_color_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#mover_color_expr}.
	 * @param ctx the parse tree
	 */
	void exitMover_color_expr(MyDSLParser.Mover_color_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#drag_coefficient_expr}.
	 * @param ctx the parse tree
	 */
	void enterDrag_coefficient_expr(MyDSLParser.Drag_coefficient_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#drag_coefficient_expr}.
	 * @param ctx the parse tree
	 */
	void exitDrag_coefficient_expr(MyDSLParser.Drag_coefficient_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#liquid_color_expr}.
	 * @param ctx the parse tree
	 */
	void enterLiquid_color_expr(MyDSLParser.Liquid_color_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#liquid_color_expr}.
	 * @param ctx the parse tree
	 */
	void exitLiquid_color_expr(MyDSLParser.Liquid_color_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#attraction_force}.
	 * @param ctx the parse tree
	 */
	void enterAttraction_force(MyDSLParser.Attraction_forceContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#attraction_force}.
	 * @param ctx the parse tree
	 */
	void exitAttraction_force(MyDSLParser.Attraction_forceContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#mover1_expr}.
	 * @param ctx the parse tree
	 */
	void enterMover1_expr(MyDSLParser.Mover1_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#mover1_expr}.
	 * @param ctx the parse tree
	 */
	void exitMover1_expr(MyDSLParser.Mover1_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#mover2_expr}.
	 * @param ctx the parse tree
	 */
	void enterMover2_expr(MyDSLParser.Mover2_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#mover2_expr}.
	 * @param ctx the parse tree
	 */
	void exitMover2_expr(MyDSLParser.Mover2_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#wave}.
	 * @param ctx the parse tree
	 */
	void enterWave(MyDSLParser.WaveContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#wave}.
	 * @param ctx the parse tree
	 */
	void exitWave(MyDSLParser.WaveContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#start_angle_expr}.
	 * @param ctx the parse tree
	 */
	void enterStart_angle_expr(MyDSLParser.Start_angle_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#start_angle_expr}.
	 * @param ctx the parse tree
	 */
	void exitStart_angle_expr(MyDSLParser.Start_angle_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#angle_velocity_expr}.
	 * @param ctx the parse tree
	 */
	void enterAngle_velocity_expr(MyDSLParser.Angle_velocity_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#angle_velocity_expr}.
	 * @param ctx the parse tree
	 */
	void exitAngle_velocity_expr(MyDSLParser.Angle_velocity_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#amplitude_expr}.
	 * @param ctx the parse tree
	 */
	void enterAmplitude_expr(MyDSLParser.Amplitude_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#amplitude_expr}.
	 * @param ctx the parse tree
	 */
	void exitAmplitude_expr(MyDSLParser.Amplitude_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#frequency_expr}.
	 * @param ctx the parse tree
	 */
	void enterFrequency_expr(MyDSLParser.Frequency_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#frequency_expr}.
	 * @param ctx the parse tree
	 */
	void exitFrequency_expr(MyDSLParser.Frequency_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#phase_shift_expr}.
	 * @param ctx the parse tree
	 */
	void enterPhase_shift_expr(MyDSLParser.Phase_shift_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#phase_shift_expr}.
	 * @param ctx the parse tree
	 */
	void exitPhase_shift_expr(MyDSLParser.Phase_shift_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#uniform_motion}.
	 * @param ctx the parse tree
	 */
	void enterUniform_motion(MyDSLParser.Uniform_motionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#uniform_motion}.
	 * @param ctx the parse tree
	 */
	void exitUniform_motion(MyDSLParser.Uniform_motionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#mover_expr}.
	 * @param ctx the parse tree
	 */
	void enterMover_expr(MyDSLParser.Mover_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#mover_expr}.
	 * @param ctx the parse tree
	 */
	void exitMover_expr(MyDSLParser.Mover_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#initial_speed_expr}.
	 * @param ctx the parse tree
	 */
	void enterInitial_speed_expr(MyDSLParser.Initial_speed_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#initial_speed_expr}.
	 * @param ctx the parse tree
	 */
	void exitInitial_speed_expr(MyDSLParser.Initial_speed_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#accelerated_motion}.
	 * @param ctx the parse tree
	 */
	void enterAccelerated_motion(MyDSLParser.Accelerated_motionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#accelerated_motion}.
	 * @param ctx the parse tree
	 */
	void exitAccelerated_motion(MyDSLParser.Accelerated_motionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#initial_acceleration_expr}.
	 * @param ctx the parse tree
	 */
	void enterInitial_acceleration_expr(MyDSLParser.Initial_acceleration_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#initial_acceleration_expr}.
	 * @param ctx the parse tree
	 */
	void exitInitial_acceleration_expr(MyDSLParser.Initial_acceleration_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#circular_motion}.
	 * @param ctx the parse tree
	 */
	void enterCircular_motion(MyDSLParser.Circular_motionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#circular_motion}.
	 * @param ctx the parse tree
	 */
	void exitCircular_motion(MyDSLParser.Circular_motionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#radius_expr}.
	 * @param ctx the parse tree
	 */
	void enterRadius_expr(MyDSLParser.Radius_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#radius_expr}.
	 * @param ctx the parse tree
	 */
	void exitRadius_expr(MyDSLParser.Radius_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#angular_speed_expr}.
	 * @param ctx the parse tree
	 */
	void enterAngular_speed_expr(MyDSLParser.Angular_speed_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#angular_speed_expr}.
	 * @param ctx the parse tree
	 */
	void exitAngular_speed_expr(MyDSLParser.Angular_speed_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#ball_expr}.
	 * @param ctx the parse tree
	 */
	void enterBall_expr(MyDSLParser.Ball_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#ball_expr}.
	 * @param ctx the parse tree
	 */
	void exitBall_expr(MyDSLParser.Ball_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#gravity}.
	 * @param ctx the parse tree
	 */
	void enterGravity(MyDSLParser.GravityContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#gravity}.
	 * @param ctx the parse tree
	 */
	void exitGravity(MyDSLParser.GravityContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#earth_expr}.
	 * @param ctx the parse tree
	 */
	void enterEarth_expr(MyDSLParser.Earth_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#earth_expr}.
	 * @param ctx the parse tree
	 */
	void exitEarth_expr(MyDSLParser.Earth_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#moon_expr}.
	 * @param ctx the parse tree
	 */
	void enterMoon_expr(MyDSLParser.Moon_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#moon_expr}.
	 * @param ctx the parse tree
	 */
	void exitMoon_expr(MyDSLParser.Moon_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#spring}.
	 * @param ctx the parse tree
	 */
	void enterSpring(MyDSLParser.SpringContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#spring}.
	 * @param ctx the parse tree
	 */
	void exitSpring(MyDSLParser.SpringContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#spring_constant_expr}.
	 * @param ctx the parse tree
	 */
	void enterSpring_constant_expr(MyDSLParser.Spring_constant_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#spring_constant_expr}.
	 * @param ctx the parse tree
	 */
	void exitSpring_constant_expr(MyDSLParser.Spring_constant_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#damping_expr}.
	 * @param ctx the parse tree
	 */
	void enterDamping_expr(MyDSLParser.Damping_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#damping_expr}.
	 * @param ctx the parse tree
	 */
	void exitDamping_expr(MyDSLParser.Damping_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#spring_rest_length_expr}.
	 * @param ctx the parse tree
	 */
	void enterSpring_rest_length_expr(MyDSLParser.Spring_rest_length_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#spring_rest_length_expr}.
	 * @param ctx the parse tree
	 */
	void exitSpring_rest_length_expr(MyDSLParser.Spring_rest_length_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#floor_friction_expr}.
	 * @param ctx the parse tree
	 */
	void enterFloor_friction_expr(MyDSLParser.Floor_friction_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#floor_friction_expr}.
	 * @param ctx the parse tree
	 */
	void exitFloor_friction_expr(MyDSLParser.Floor_friction_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#spring_expr}.
	 * @param ctx the parse tree
	 */
	void enterSpring_expr(MyDSLParser.Spring_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#spring_expr}.
	 * @param ctx the parse tree
	 */
	void exitSpring_expr(MyDSLParser.Spring_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#x_anchor_position_expr}.
	 * @param ctx the parse tree
	 */
	void enterX_anchor_position_expr(MyDSLParser.X_anchor_position_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#x_anchor_position_expr}.
	 * @param ctx the parse tree
	 */
	void exitX_anchor_position_expr(MyDSLParser.X_anchor_position_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#y_anchor_position_expr}.
	 * @param ctx the parse tree
	 */
	void enterY_anchor_position_expr(MyDSLParser.Y_anchor_position_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#y_anchor_position_expr}.
	 * @param ctx the parse tree
	 */
	void exitY_anchor_position_expr(MyDSLParser.Y_anchor_position_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#num_coils_expr}.
	 * @param ctx the parse tree
	 */
	void enterNum_coils_expr(MyDSLParser.Num_coils_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#num_coils_expr}.
	 * @param ctx the parse tree
	 */
	void exitNum_coils_expr(MyDSLParser.Num_coils_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#pendulum}.
	 * @param ctx the parse tree
	 */
	void enterPendulum(MyDSLParser.PendulumContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#pendulum}.
	 * @param ctx the parse tree
	 */
	void exitPendulum(MyDSLParser.PendulumContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#length_expr}.
	 * @param ctx the parse tree
	 */
	void enterLength_expr(MyDSLParser.Length_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#length_expr}.
	 * @param ctx the parse tree
	 */
	void exitLength_expr(MyDSLParser.Length_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#ball_radius_expr}.
	 * @param ctx the parse tree
	 */
	void enterBall_radius_expr(MyDSLParser.Ball_radius_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#ball_radius_expr}.
	 * @param ctx the parse tree
	 */
	void exitBall_radius_expr(MyDSLParser.Ball_radius_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#initial_angle_expr}.
	 * @param ctx the parse tree
	 */
	void enterInitial_angle_expr(MyDSLParser.Initial_angle_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#initial_angle_expr}.
	 * @param ctx the parse tree
	 */
	void exitInitial_angle_expr(MyDSLParser.Initial_angle_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#angular_velocity_expr}.
	 * @param ctx the parse tree
	 */
	void enterAngular_velocity_expr(MyDSLParser.Angular_velocity_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#angular_velocity_expr}.
	 * @param ctx the parse tree
	 */
	void exitAngular_velocity_expr(MyDSLParser.Angular_velocity_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#angular_acceleration_expr}.
	 * @param ctx the parse tree
	 */
	void enterAngular_acceleration_expr(MyDSLParser.Angular_acceleration_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#angular_acceleration_expr}.
	 * @param ctx the parse tree
	 */
	void exitAngular_acceleration_expr(MyDSLParser.Angular_acceleration_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#air_resistance_expr}.
	 * @param ctx the parse tree
	 */
	void enterAir_resistance_expr(MyDSLParser.Air_resistance_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#air_resistance_expr}.
	 * @param ctx the parse tree
	 */
	void exitAir_resistance_expr(MyDSLParser.Air_resistance_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#rolling_uphill}.
	 * @param ctx the parse tree
	 */
	void enterRolling_uphill(MyDSLParser.Rolling_uphillContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#rolling_uphill}.
	 * @param ctx the parse tree
	 */
	void exitRolling_uphill(MyDSLParser.Rolling_uphillContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#gravitational_acceleration_expr}.
	 * @param ctx the parse tree
	 */
	void enterGravitational_acceleration_expr(MyDSLParser.Gravitational_acceleration_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#gravitational_acceleration_expr}.
	 * @param ctx the parse tree
	 */
	void exitGravitational_acceleration_expr(MyDSLParser.Gravitational_acceleration_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#coefficient_of_friction_expr}.
	 * @param ctx the parse tree
	 */
	void enterCoefficient_of_friction_expr(MyDSLParser.Coefficient_of_friction_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#coefficient_of_friction_expr}.
	 * @param ctx the parse tree
	 */
	void exitCoefficient_of_friction_expr(MyDSLParser.Coefficient_of_friction_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#bounciness_expr}.
	 * @param ctx the parse tree
	 */
	void enterBounciness_expr(MyDSLParser.Bounciness_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#bounciness_expr}.
	 * @param ctx the parse tree
	 */
	void exitBounciness_expr(MyDSLParser.Bounciness_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#angle_expr}.
	 * @param ctx the parse tree
	 */
	void enterAngle_expr(MyDSLParser.Angle_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#angle_expr}.
	 * @param ctx the parse tree
	 */
	void exitAngle_expr(MyDSLParser.Angle_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#velocity_along_incline_expr}.
	 * @param ctx the parse tree
	 */
	void enterVelocity_along_incline_expr(MyDSLParser.Velocity_along_incline_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#velocity_along_incline_expr}.
	 * @param ctx the parse tree
	 */
	void exitVelocity_along_incline_expr(MyDSLParser.Velocity_along_incline_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#mover_basic_properties}.
	 * @param ctx the parse tree
	 */
	void enterMover_basic_properties(MyDSLParser.Mover_basic_propertiesContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#mover_basic_properties}.
	 * @param ctx the parse tree
	 */
	void exitMover_basic_properties(MyDSLParser.Mover_basic_propertiesContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#mass_expr}.
	 * @param ctx the parse tree
	 */
	void enterMass_expr(MyDSLParser.Mass_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#mass_expr}.
	 * @param ctx the parse tree
	 */
	void exitMass_expr(MyDSLParser.Mass_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#velocity_expr}.
	 * @param ctx the parse tree
	 */
	void enterVelocity_expr(MyDSLParser.Velocity_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#velocity_expr}.
	 * @param ctx the parse tree
	 */
	void exitVelocity_expr(MyDSLParser.Velocity_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#x_velocity_expr}.
	 * @param ctx the parse tree
	 */
	void enterX_velocity_expr(MyDSLParser.X_velocity_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#x_velocity_expr}.
	 * @param ctx the parse tree
	 */
	void exitX_velocity_expr(MyDSLParser.X_velocity_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#y_velocity_expr}.
	 * @param ctx the parse tree
	 */
	void enterY_velocity_expr(MyDSLParser.Y_velocity_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#y_velocity_expr}.
	 * @param ctx the parse tree
	 */
	void exitY_velocity_expr(MyDSLParser.Y_velocity_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#position_expr}.
	 * @param ctx the parse tree
	 */
	void enterPosition_expr(MyDSLParser.Position_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#position_expr}.
	 * @param ctx the parse tree
	 */
	void exitPosition_expr(MyDSLParser.Position_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#x_position_expr}.
	 * @param ctx the parse tree
	 */
	void enterX_position_expr(MyDSLParser.X_position_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#x_position_expr}.
	 * @param ctx the parse tree
	 */
	void exitX_position_expr(MyDSLParser.X_position_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#y_position_expr}.
	 * @param ctx the parse tree
	 */
	void enterY_position_expr(MyDSLParser.Y_position_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#y_position_expr}.
	 * @param ctx the parse tree
	 */
	void exitY_position_expr(MyDSLParser.Y_position_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#color_expr}.
	 * @param ctx the parse tree
	 */
	void enterColor_expr(MyDSLParser.Color_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#color_expr}.
	 * @param ctx the parse tree
	 */
	void exitColor_expr(MyDSLParser.Color_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#red_value_expr}.
	 * @param ctx the parse tree
	 */
	void enterRed_value_expr(MyDSLParser.Red_value_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#red_value_expr}.
	 * @param ctx the parse tree
	 */
	void exitRed_value_expr(MyDSLParser.Red_value_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#green_value_expr}.
	 * @param ctx the parse tree
	 */
	void enterGreen_value_expr(MyDSLParser.Green_value_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#green_value_expr}.
	 * @param ctx the parse tree
	 */
	void exitGreen_value_expr(MyDSLParser.Green_value_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#blue_value_expr}.
	 * @param ctx the parse tree
	 */
	void enterBlue_value_expr(MyDSLParser.Blue_value_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#blue_value_expr}.
	 * @param ctx the parse tree
	 */
	void exitBlue_value_expr(MyDSLParser.Blue_value_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#value_expr}.
	 * @param ctx the parse tree
	 */
	void enterValue_expr(MyDSLParser.Value_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#value_expr}.
	 * @param ctx the parse tree
	 */
	void exitValue_expr(MyDSLParser.Value_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#simple_value}.
	 * @param ctx the parse tree
	 */
	void enterSimple_value(MyDSLParser.Simple_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#simple_value}.
	 * @param ctx the parse tree
	 */
	void exitSimple_value(MyDSLParser.Simple_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#conditional_value}.
	 * @param ctx the parse tree
	 */
	void enterConditional_value(MyDSLParser.Conditional_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#conditional_value}.
	 * @param ctx the parse tree
	 */
	void exitConditional_value(MyDSLParser.Conditional_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#loop_value}.
	 * @param ctx the parse tree
	 */
	void enterLoop_value(MyDSLParser.Loop_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#loop_value}.
	 * @param ctx the parse tree
	 */
	void exitLoop_value(MyDSLParser.Loop_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#initial_value}.
	 * @param ctx the parse tree
	 */
	void enterInitial_value(MyDSLParser.Initial_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#initial_value}.
	 * @param ctx the parse tree
	 */
	void exitInitial_value(MyDSLParser.Initial_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#multiplier}.
	 * @param ctx the parse tree
	 */
	void enterMultiplier(MyDSLParser.MultiplierContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#multiplier}.
	 * @param ctx the parse tree
	 */
	void exitMultiplier(MyDSLParser.MultiplierContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(MyDSLParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(MyDSLParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#comparator}.
	 * @param ctx the parse tree
	 */
	void enterComparator(MyDSLParser.ComparatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#comparator}.
	 * @param ctx the parse tree
	 */
	void exitComparator(MyDSLParser.ComparatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyDSLParser#reference}.
	 * @param ctx the parse tree
	 */
	void enterReference(MyDSLParser.ReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyDSLParser#reference}.
	 * @param ctx the parse tree
	 */
	void exitReference(MyDSLParser.ReferenceContext ctx);
}