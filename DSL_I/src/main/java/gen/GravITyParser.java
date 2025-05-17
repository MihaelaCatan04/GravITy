package gen;
// Generated from C:/Users/ionvo/OneDrive/Desktop/GravITy/DSL_I/src/main/antlr4/GravITy.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class GravITyParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
			new PredictionContextCache();
	public static final int
			T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9,
			T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17,
			T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24,
			T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31,
			T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38,
			T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45,
			T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52,
			T__52=53, T__53=54, T__54=55, T__55=56, T__56=57, T__57=58, T__58=59,
			T__59=60, T__60=61, T__61=62, T__62=63, T__63=64, T__64=65, T__65=66,
			T__66=67, T__67=68, T__68=69, T__69=70, T__70=71, T__71=72, T__72=73,
			T__73=74, T__74=75, T__75=76, T__76=77, T__77=78, NUMBER=79, INTEGER=80,
			FLOAT=81, IDENTIFIER=82, COMMENT=83, WS=84;
	public static final int
			RULE_simulation = 0, RULE_simulation_body = 1, RULE_physics_module = 2,
			RULE_collision = 3, RULE_movers_list = 4, RULE_mover = 5, RULE_mover_properties = 6,
			RULE_electrostatic_field = 7, RULE_particle_radius_expr = 8, RULE_flux_resolution_expr = 9,
			RULE_drag_force = 10, RULE_mover_color_expr = 11, RULE_drag_coefficient_expr = 12,
			RULE_liquid_color_expr = 13, RULE_attraction_force = 14, RULE_mover1_expr = 15,
			RULE_mover2_expr = 16, RULE_wave = 17, RULE_start_angle_expr = 18, RULE_angle_velocity_expr = 19,
			RULE_amplitude_expr = 20, RULE_frequency_expr = 21, RULE_phase_shift_expr = 22,
			RULE_uniform_motion = 23, RULE_mover_expr = 24, RULE_initial_speed_expr = 25,
			RULE_accelerated_motion = 26, RULE_initial_acceleration_expr = 27, RULE_circular_motion = 28,
			RULE_radius_expr = 29, RULE_angular_speed_expr = 30, RULE_ball_expr = 31,
			RULE_gravity = 32, RULE_earth_expr = 33, RULE_moon_expr = 34, RULE_spring = 35,
			RULE_spring_constant_expr = 36, RULE_damping_expr = 37, RULE_spring_rest_length_expr = 38,
			RULE_floor_friction_expr = 39, RULE_spring_expr = 40, RULE_x_anchor_position_expr = 41,
			RULE_y_anchor_position_expr = 42, RULE_num_coils_expr = 43, RULE_pendulum = 44,
			RULE_length_expr = 45, RULE_ball_radius_expr = 46, RULE_initial_angle_expr = 47,
			RULE_angular_velocity_expr = 48, RULE_angular_acceleration_expr = 49,
			RULE_air_resistance_expr = 50, RULE_rolling_uphill = 51, RULE_gravitational_acceleration_expr = 52,
			RULE_coefficient_of_friction_expr = 53, RULE_bounciness_expr = 54, RULE_angle_expr = 55,
			RULE_velocity_along_incline_expr = 56, RULE_mover_basic_properties = 57,
			RULE_mass_expr = 58, RULE_velocity_expr = 59, RULE_x_velocity_expr = 60,
			RULE_y_velocity_expr = 61, RULE_position_expr = 62, RULE_x_position_expr = 63,
			RULE_y_position_expr = 64, RULE_color_expr = 65, RULE_red_value_expr = 66,
			RULE_green_value_expr = 67, RULE_blue_value_expr = 68, RULE_value_expr = 69,
			RULE_simple_value = 70, RULE_conditional_value = 71, RULE_loop_value = 72,
			RULE_initial_value = 73, RULE_multiplier = 74, RULE_condition = 75, RULE_comparator = 76,
			RULE_reference = 77;
	private static String[] makeRuleNames() {
		return new String[] {
				"simulation", "simulation_body", "physics_module", "collision", "movers_list",
				"mover", "mover_properties", "electrostatic_field", "particle_radius_expr",
				"flux_resolution_expr", "drag_force", "mover_color_expr", "drag_coefficient_expr",
				"liquid_color_expr", "attraction_force", "mover1_expr", "mover2_expr",
				"wave", "start_angle_expr", "angle_velocity_expr", "amplitude_expr",
				"frequency_expr", "phase_shift_expr", "uniform_motion", "mover_expr",
				"initial_speed_expr", "accelerated_motion", "initial_acceleration_expr",
				"circular_motion", "radius_expr", "angular_speed_expr", "ball_expr",
				"gravity", "earth_expr", "moon_expr", "spring", "spring_constant_expr",
				"damping_expr", "spring_rest_length_expr", "floor_friction_expr", "spring_expr",
				"x_anchor_position_expr", "y_anchor_position_expr", "num_coils_expr",
				"pendulum", "length_expr", "ball_radius_expr", "initial_angle_expr",
				"angular_velocity_expr", "angular_acceleration_expr", "air_resistance_expr",
				"rolling_uphill", "gravitational_acceleration_expr", "coefficient_of_friction_expr",
				"bounciness_expr", "angle_expr", "velocity_along_incline_expr", "mover_basic_properties",
				"mass_expr", "velocity_expr", "x_velocity_expr", "y_velocity_expr", "position_expr",
				"x_position_expr", "y_position_expr", "color_expr", "red_value_expr",
				"green_value_expr", "blue_value_expr", "value_expr", "simple_value",
				"conditional_value", "loop_value", "initial_value", "multiplier", "condition",
				"comparator", "reference"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
				null, "'simulation'", "'{'", "'}'", "'collision'", "'mover'", "'electrostatic_field'",
				"'particle_radius'", "':'", "'flux_resolution'", "'drag_force'", "'mover_color'",
				"'drag_coefficient'", "'liquid_color'", "'attraction_force'", "'mover1'",
				"'mover2'", "'wave'", "'start_angle'", "'angle_velocity'", "'amplitude'",
				"'frequency'", "'phase_shift'", "'uniform_motion'", "'initial_speed'",
				"'accelerated_motion'", "'initial_acceleration'", "'circular_motion'",
				"'radius'", "'angular_speed'", "'ball'", "'gravity'", "'earth'", "'moon'",
				"'spring'", "'spring_constant'", "'damping'", "'spring_rest_length'",
				"'floor_friction'", "'x_anchor_position'", "'y_anchor_position'", "'num_coils'",
				"'pendulum'", "'length'", "'ball_radius'", "'initial_angle'", "'angular_velocity'",
				"'angular_acceleration'", "'air_resistance'", "'rolling_uphill'", "'gravitational_acceleration'",
				"'coefficient_of_friction'", "'bounciness'", "'angle'", "'velocity_along_incline'",
				"'mass'", "'velocity'", "'x_velocity'", "'y_velocity'", "'position'",
				"'x_position'", "'y_position'", "'color'", "'red_value'", "'green_value'",
				"'blue_value'", "'if'", "'then'", "'else'", "'repeat'", "'times'", "'*'",
				"'>'", "'<'", "'=='", "'>='", "'<='", "'!='", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
				null, null, null, null, null, null, null, null, null, null, null, null,
				null, null, null, null, null, null, null, null, null, null, null, null,
				null, null, null, null, null, null, null, null, null, null, null, null,
				null, null, null, null, null, null, null, null, null, null, null, null,
				null, null, null, null, null, null, null, null, null, null, null, null,
				null, null, null, null, null, null, null, null, null, null, null, null,
				null, null, null, null, null, null, null, "NUMBER", "INTEGER", "FLOAT",
				"IDENTIFIER", "COMMENT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "GravITy.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GravITyParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SimulationContext extends ParserRuleContext {
		public Simulation_bodyContext simulation_body() {
			return getRuleContext(Simulation_bodyContext.class,0);
		}
		public SimulationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simulation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterSimulation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitSimulation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitSimulation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimulationContext simulation() throws RecognitionException {
		SimulationContext _localctx = new SimulationContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_simulation);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(156);
				match(T__0);
				setState(157);
				match(T__1);
				setState(158);
				simulation_body();
				setState(159);
				match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Simulation_bodyContext extends ParserRuleContext {
		public Physics_moduleContext physics_module() {
			return getRuleContext(Physics_moduleContext.class,0);
		}
		public Simulation_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simulation_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterSimulation_body(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitSimulation_body(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitSimulation_body(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Simulation_bodyContext simulation_body() throws RecognitionException {
		Simulation_bodyContext _localctx = new Simulation_bodyContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_simulation_body);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(161);
				physics_module();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Physics_moduleContext extends ParserRuleContext {
		public CollisionContext collision() {
			return getRuleContext(CollisionContext.class,0);
		}
		public Electrostatic_fieldContext electrostatic_field() {
			return getRuleContext(Electrostatic_fieldContext.class,0);
		}
		public Drag_forceContext drag_force() {
			return getRuleContext(Drag_forceContext.class,0);
		}
		public Attraction_forceContext attraction_force() {
			return getRuleContext(Attraction_forceContext.class,0);
		}
		public WaveContext wave() {
			return getRuleContext(WaveContext.class,0);
		}
		public Uniform_motionContext uniform_motion() {
			return getRuleContext(Uniform_motionContext.class,0);
		}
		public Accelerated_motionContext accelerated_motion() {
			return getRuleContext(Accelerated_motionContext.class,0);
		}
		public Circular_motionContext circular_motion() {
			return getRuleContext(Circular_motionContext.class,0);
		}
		public GravityContext gravity() {
			return getRuleContext(GravityContext.class,0);
		}
		public SpringContext spring() {
			return getRuleContext(SpringContext.class,0);
		}
		public PendulumContext pendulum() {
			return getRuleContext(PendulumContext.class,0);
		}
		public Rolling_uphillContext rolling_uphill() {
			return getRuleContext(Rolling_uphillContext.class,0);
		}
		public Physics_moduleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_physics_module; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterPhysics_module(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitPhysics_module(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitPhysics_module(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Physics_moduleContext physics_module() throws RecognitionException {
		Physics_moduleContext _localctx = new Physics_moduleContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_physics_module);
		try {
			setState(175);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
				case T__3:
					enterOuterAlt(_localctx, 1);
				{
					setState(163);
					collision();
				}
				break;
				case T__5:
					enterOuterAlt(_localctx, 2);
				{
					setState(164);
					electrostatic_field();
				}
				break;
				case T__9:
					enterOuterAlt(_localctx, 3);
				{
					setState(165);
					drag_force();
				}
				break;
				case T__13:
					enterOuterAlt(_localctx, 4);
				{
					setState(166);
					attraction_force();
				}
				break;
				case T__16:
					enterOuterAlt(_localctx, 5);
				{
					setState(167);
					wave();
				}
				break;
				case T__22:
					enterOuterAlt(_localctx, 6);
				{
					setState(168);
					uniform_motion();
				}
				break;
				case T__24:
					enterOuterAlt(_localctx, 7);
				{
					setState(169);
					accelerated_motion();
				}
				break;
				case T__26:
					enterOuterAlt(_localctx, 8);
				{
					setState(170);
					circular_motion();
				}
				break;
				case T__30:
					enterOuterAlt(_localctx, 9);
				{
					setState(171);
					gravity();
				}
				break;
				case T__33:
					enterOuterAlt(_localctx, 10);
				{
					setState(172);
					spring();
				}
				break;
				case T__41:
					enterOuterAlt(_localctx, 11);
				{
					setState(173);
					pendulum();
				}
				break;
				case T__48:
					enterOuterAlt(_localctx, 12);
				{
					setState(174);
					rolling_uphill();
				}
				break;
				default:
					throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CollisionContext extends ParserRuleContext {
		public Movers_listContext movers_list() {
			return getRuleContext(Movers_listContext.class,0);
		}
		public CollisionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_collision; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterCollision(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitCollision(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitCollision(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CollisionContext collision() throws RecognitionException {
		CollisionContext _localctx = new CollisionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_collision);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(177);
				match(T__3);
				setState(178);
				match(T__1);
				setState(179);
				movers_list();
				setState(180);
				match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Movers_listContext extends ParserRuleContext {
		public List<MoverContext> mover() {
			return getRuleContexts(MoverContext.class);
		}
		public MoverContext mover(int i) {
			return getRuleContext(MoverContext.class,i);
		}
		public Movers_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_movers_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterMovers_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitMovers_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitMovers_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Movers_listContext movers_list() throws RecognitionException {
		Movers_listContext _localctx = new Movers_listContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_movers_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(183);
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
						{
							setState(182);
							mover();
						}
					}
					setState(185);
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__4 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MoverContext extends ParserRuleContext {
		public Mover_propertiesContext mover_properties() {
			return getRuleContext(Mover_propertiesContext.class,0);
		}
		public MoverContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mover; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterMover(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitMover(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitMover(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MoverContext mover() throws RecognitionException {
		MoverContext _localctx = new MoverContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_mover);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(187);
				match(T__4);
				setState(188);
				match(T__1);
				setState(189);
				mover_properties();
				setState(190);
				match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Mover_propertiesContext extends ParserRuleContext {
		public Radius_exprContext radius_expr() {
			return getRuleContext(Radius_exprContext.class,0);
		}
		public Mass_exprContext mass_expr() {
			return getRuleContext(Mass_exprContext.class,0);
		}
		public Velocity_exprContext velocity_expr() {
			return getRuleContext(Velocity_exprContext.class,0);
		}
		public Position_exprContext position_expr() {
			return getRuleContext(Position_exprContext.class,0);
		}
		public Color_exprContext color_expr() {
			return getRuleContext(Color_exprContext.class,0);
		}
		public Mover_propertiesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mover_properties; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterMover_properties(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitMover_properties(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitMover_properties(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mover_propertiesContext mover_properties() throws RecognitionException {
		Mover_propertiesContext _localctx = new Mover_propertiesContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_mover_properties);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(192);
				radius_expr();
				setState(193);
				mass_expr();
				setState(194);
				velocity_expr();
				setState(195);
				position_expr();
				setState(196);
				color_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Electrostatic_fieldContext extends ParserRuleContext {
		public Particle_radius_exprContext particle_radius_expr() {
			return getRuleContext(Particle_radius_exprContext.class,0);
		}
		public Flux_resolution_exprContext flux_resolution_expr() {
			return getRuleContext(Flux_resolution_exprContext.class,0);
		}
		public Electrostatic_fieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_electrostatic_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterElectrostatic_field(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitElectrostatic_field(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitElectrostatic_field(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Electrostatic_fieldContext electrostatic_field() throws RecognitionException {
		Electrostatic_fieldContext _localctx = new Electrostatic_fieldContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_electrostatic_field);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(198);
				match(T__5);
				setState(199);
				match(T__1);
				setState(200);
				particle_radius_expr();
				setState(201);
				flux_resolution_expr();
				setState(202);
				match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Particle_radius_exprContext extends ParserRuleContext {
		public Value_exprContext value_expr() {
			return getRuleContext(Value_exprContext.class,0);
		}
		public Particle_radius_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_particle_radius_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterParticle_radius_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitParticle_radius_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitParticle_radius_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Particle_radius_exprContext particle_radius_expr() throws RecognitionException {
		Particle_radius_exprContext _localctx = new Particle_radius_exprContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_particle_radius_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(204);
				match(T__6);
				setState(205);
				match(T__7);
				setState(206);
				value_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Flux_resolution_exprContext extends ParserRuleContext {
		public Value_exprContext value_expr() {
			return getRuleContext(Value_exprContext.class,0);
		}
		public Flux_resolution_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flux_resolution_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterFlux_resolution_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitFlux_resolution_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitFlux_resolution_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Flux_resolution_exprContext flux_resolution_expr() throws RecognitionException {
		Flux_resolution_exprContext _localctx = new Flux_resolution_exprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_flux_resolution_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(208);
				match(T__8);
				setState(209);
				match(T__7);
				setState(210);
				value_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Drag_forceContext extends ParserRuleContext {
		public Mover_color_exprContext mover_color_expr() {
			return getRuleContext(Mover_color_exprContext.class,0);
		}
		public Drag_coefficient_exprContext drag_coefficient_expr() {
			return getRuleContext(Drag_coefficient_exprContext.class,0);
		}
		public Liquid_color_exprContext liquid_color_expr() {
			return getRuleContext(Liquid_color_exprContext.class,0);
		}
		public Drag_forceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drag_force; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterDrag_force(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitDrag_force(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitDrag_force(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Drag_forceContext drag_force() throws RecognitionException {
		Drag_forceContext _localctx = new Drag_forceContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_drag_force);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(212);
				match(T__9);
				setState(213);
				match(T__1);
				setState(214);
				mover_color_expr();
				setState(215);
				drag_coefficient_expr();
				setState(216);
				liquid_color_expr();
				setState(217);
				match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Mover_color_exprContext extends ParserRuleContext {
		public Red_value_exprContext red_value_expr() {
			return getRuleContext(Red_value_exprContext.class,0);
		}
		public Green_value_exprContext green_value_expr() {
			return getRuleContext(Green_value_exprContext.class,0);
		}
		public Blue_value_exprContext blue_value_expr() {
			return getRuleContext(Blue_value_exprContext.class,0);
		}
		public Mover_color_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mover_color_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterMover_color_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitMover_color_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitMover_color_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mover_color_exprContext mover_color_expr() throws RecognitionException {
		Mover_color_exprContext _localctx = new Mover_color_exprContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_mover_color_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(219);
				match(T__10);
				setState(220);
				match(T__1);
				setState(221);
				red_value_expr();
				setState(222);
				green_value_expr();
				setState(223);
				blue_value_expr();
				setState(224);
				match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Drag_coefficient_exprContext extends ParserRuleContext {
		public Value_exprContext value_expr() {
			return getRuleContext(Value_exprContext.class,0);
		}
		public Drag_coefficient_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drag_coefficient_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterDrag_coefficient_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitDrag_coefficient_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitDrag_coefficient_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Drag_coefficient_exprContext drag_coefficient_expr() throws RecognitionException {
		Drag_coefficient_exprContext _localctx = new Drag_coefficient_exprContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_drag_coefficient_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(226);
				match(T__11);
				setState(227);
				match(T__7);
				setState(228);
				value_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Liquid_color_exprContext extends ParserRuleContext {
		public Red_value_exprContext red_value_expr() {
			return getRuleContext(Red_value_exprContext.class,0);
		}
		public Green_value_exprContext green_value_expr() {
			return getRuleContext(Green_value_exprContext.class,0);
		}
		public Blue_value_exprContext blue_value_expr() {
			return getRuleContext(Blue_value_exprContext.class,0);
		}
		public Liquid_color_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_liquid_color_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterLiquid_color_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitLiquid_color_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitLiquid_color_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Liquid_color_exprContext liquid_color_expr() throws RecognitionException {
		Liquid_color_exprContext _localctx = new Liquid_color_exprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_liquid_color_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(230);
				match(T__12);
				setState(231);
				match(T__1);
				setState(232);
				red_value_expr();
				setState(233);
				green_value_expr();
				setState(234);
				blue_value_expr();
				setState(235);
				match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Attraction_forceContext extends ParserRuleContext {
		public Mover1_exprContext mover1_expr() {
			return getRuleContext(Mover1_exprContext.class,0);
		}
		public Mover2_exprContext mover2_expr() {
			return getRuleContext(Mover2_exprContext.class,0);
		}
		public Attraction_forceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attraction_force; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterAttraction_force(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitAttraction_force(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitAttraction_force(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Attraction_forceContext attraction_force() throws RecognitionException {
		Attraction_forceContext _localctx = new Attraction_forceContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_attraction_force);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(237);
				match(T__13);
				setState(238);
				match(T__1);
				setState(239);
				mover1_expr();
				setState(240);
				mover2_expr();
				setState(241);
				match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Mover1_exprContext extends ParserRuleContext {
		public Mover_propertiesContext mover_properties() {
			return getRuleContext(Mover_propertiesContext.class,0);
		}
		public Mover1_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mover1_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterMover1_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitMover1_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitMover1_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mover1_exprContext mover1_expr() throws RecognitionException {
		Mover1_exprContext _localctx = new Mover1_exprContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_mover1_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(243);
				match(T__14);
				setState(244);
				match(T__1);
				setState(245);
				mover_properties();
				setState(246);
				match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Mover2_exprContext extends ParserRuleContext {
		public Mover_propertiesContext mover_properties() {
			return getRuleContext(Mover_propertiesContext.class,0);
		}
		public Mover2_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mover2_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterMover2_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitMover2_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitMover2_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mover2_exprContext mover2_expr() throws RecognitionException {
		Mover2_exprContext _localctx = new Mover2_exprContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_mover2_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(248);
				match(T__15);
				setState(249);
				match(T__1);
				setState(250);
				mover_properties();
				setState(251);
				match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WaveContext extends ParserRuleContext {
		public Start_angle_exprContext start_angle_expr() {
			return getRuleContext(Start_angle_exprContext.class,0);
		}
		public Angle_velocity_exprContext angle_velocity_expr() {
			return getRuleContext(Angle_velocity_exprContext.class,0);
		}
		public Amplitude_exprContext amplitude_expr() {
			return getRuleContext(Amplitude_exprContext.class,0);
		}
		public Frequency_exprContext frequency_expr() {
			return getRuleContext(Frequency_exprContext.class,0);
		}
		public Phase_shift_exprContext phase_shift_expr() {
			return getRuleContext(Phase_shift_exprContext.class,0);
		}
		public WaveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wave; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterWave(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitWave(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitWave(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WaveContext wave() throws RecognitionException {
		WaveContext _localctx = new WaveContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_wave);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(253);
				match(T__16);
				setState(254);
				match(T__1);
				setState(255);
				start_angle_expr();
				setState(256);
				angle_velocity_expr();
				setState(257);
				amplitude_expr();
				setState(258);
				frequency_expr();
				setState(259);
				phase_shift_expr();
				setState(260);
				match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Start_angle_exprContext extends ParserRuleContext {
		public Value_exprContext value_expr() {
			return getRuleContext(Value_exprContext.class,0);
		}
		public Start_angle_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start_angle_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterStart_angle_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitStart_angle_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitStart_angle_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Start_angle_exprContext start_angle_expr() throws RecognitionException {
		Start_angle_exprContext _localctx = new Start_angle_exprContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_start_angle_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(262);
				match(T__17);
				setState(263);
				match(T__7);
				setState(264);
				value_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Angle_velocity_exprContext extends ParserRuleContext {
		public Value_exprContext value_expr() {
			return getRuleContext(Value_exprContext.class,0);
		}
		public Angle_velocity_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_angle_velocity_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterAngle_velocity_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitAngle_velocity_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitAngle_velocity_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Angle_velocity_exprContext angle_velocity_expr() throws RecognitionException {
		Angle_velocity_exprContext _localctx = new Angle_velocity_exprContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_angle_velocity_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(266);
				match(T__18);
				setState(267);
				match(T__7);
				setState(268);
				value_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Amplitude_exprContext extends ParserRuleContext {
		public Value_exprContext value_expr() {
			return getRuleContext(Value_exprContext.class,0);
		}
		public Amplitude_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_amplitude_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterAmplitude_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitAmplitude_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitAmplitude_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Amplitude_exprContext amplitude_expr() throws RecognitionException {
		Amplitude_exprContext _localctx = new Amplitude_exprContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_amplitude_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(270);
				match(T__19);
				setState(271);
				match(T__7);
				setState(272);
				value_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Frequency_exprContext extends ParserRuleContext {
		public Value_exprContext value_expr() {
			return getRuleContext(Value_exprContext.class,0);
		}
		public Frequency_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_frequency_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterFrequency_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitFrequency_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitFrequency_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Frequency_exprContext frequency_expr() throws RecognitionException {
		Frequency_exprContext _localctx = new Frequency_exprContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_frequency_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(274);
				match(T__20);
				setState(275);
				match(T__7);
				setState(276);
				value_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Phase_shift_exprContext extends ParserRuleContext {
		public Value_exprContext value_expr() {
			return getRuleContext(Value_exprContext.class,0);
		}
		public Phase_shift_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_phase_shift_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterPhase_shift_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitPhase_shift_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitPhase_shift_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Phase_shift_exprContext phase_shift_expr() throws RecognitionException {
		Phase_shift_exprContext _localctx = new Phase_shift_exprContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_phase_shift_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(278);
				match(T__21);
				setState(279);
				match(T__7);
				setState(280);
				value_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Uniform_motionContext extends ParserRuleContext {
		public Mover_exprContext mover_expr() {
			return getRuleContext(Mover_exprContext.class,0);
		}
		public Initial_speed_exprContext initial_speed_expr() {
			return getRuleContext(Initial_speed_exprContext.class,0);
		}
		public Uniform_motionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_uniform_motion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterUniform_motion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitUniform_motion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitUniform_motion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Uniform_motionContext uniform_motion() throws RecognitionException {
		Uniform_motionContext _localctx = new Uniform_motionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_uniform_motion);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(282);
				match(T__22);
				setState(283);
				match(T__1);
				setState(284);
				mover_expr();
				setState(285);
				initial_speed_expr();
				setState(286);
				match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Mover_exprContext extends ParserRuleContext {
		public Mover_basic_propertiesContext mover_basic_properties() {
			return getRuleContext(Mover_basic_propertiesContext.class,0);
		}
		public Mover_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mover_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterMover_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitMover_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitMover_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mover_exprContext mover_expr() throws RecognitionException {
		Mover_exprContext _localctx = new Mover_exprContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_mover_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(288);
				match(T__4);
				setState(289);
				match(T__1);
				setState(290);
				mover_basic_properties();
				setState(291);
				match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Initial_speed_exprContext extends ParserRuleContext {
		public Value_exprContext value_expr() {
			return getRuleContext(Value_exprContext.class,0);
		}
		public Initial_speed_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initial_speed_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterInitial_speed_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitInitial_speed_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitInitial_speed_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Initial_speed_exprContext initial_speed_expr() throws RecognitionException {
		Initial_speed_exprContext _localctx = new Initial_speed_exprContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_initial_speed_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(293);
				match(T__23);
				setState(294);
				match(T__7);
				setState(295);
				value_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Accelerated_motionContext extends ParserRuleContext {
		public Mover_exprContext mover_expr() {
			return getRuleContext(Mover_exprContext.class,0);
		}
		public Initial_speed_exprContext initial_speed_expr() {
			return getRuleContext(Initial_speed_exprContext.class,0);
		}
		public Initial_acceleration_exprContext initial_acceleration_expr() {
			return getRuleContext(Initial_acceleration_exprContext.class,0);
		}
		public Accelerated_motionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_accelerated_motion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterAccelerated_motion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitAccelerated_motion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitAccelerated_motion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Accelerated_motionContext accelerated_motion() throws RecognitionException {
		Accelerated_motionContext _localctx = new Accelerated_motionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_accelerated_motion);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(297);
				match(T__24);
				setState(298);
				match(T__1);
				setState(299);
				mover_expr();
				setState(300);
				initial_speed_expr();
				setState(301);
				initial_acceleration_expr();
				setState(302);
				match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Initial_acceleration_exprContext extends ParserRuleContext {
		public Value_exprContext value_expr() {
			return getRuleContext(Value_exprContext.class,0);
		}
		public Initial_acceleration_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initial_acceleration_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterInitial_acceleration_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitInitial_acceleration_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitInitial_acceleration_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Initial_acceleration_exprContext initial_acceleration_expr() throws RecognitionException {
		Initial_acceleration_exprContext _localctx = new Initial_acceleration_exprContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_initial_acceleration_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(304);
				match(T__25);
				setState(305);
				match(T__7);
				setState(306);
				value_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Circular_motionContext extends ParserRuleContext {
		public Radius_exprContext radius_expr() {
			return getRuleContext(Radius_exprContext.class,0);
		}
		public Angular_speed_exprContext angular_speed_expr() {
			return getRuleContext(Angular_speed_exprContext.class,0);
		}
		public Ball_exprContext ball_expr() {
			return getRuleContext(Ball_exprContext.class,0);
		}
		public Circular_motionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_circular_motion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterCircular_motion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitCircular_motion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitCircular_motion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Circular_motionContext circular_motion() throws RecognitionException {
		Circular_motionContext _localctx = new Circular_motionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_circular_motion);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(308);
				match(T__26);
				setState(309);
				match(T__1);
				setState(310);
				radius_expr();
				setState(311);
				angular_speed_expr();
				setState(312);
				ball_expr();
				setState(313);
				match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Radius_exprContext extends ParserRuleContext {
		public Value_exprContext value_expr() {
			return getRuleContext(Value_exprContext.class,0);
		}
		public Radius_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_radius_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterRadius_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitRadius_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitRadius_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Radius_exprContext radius_expr() throws RecognitionException {
		Radius_exprContext _localctx = new Radius_exprContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_radius_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(315);
				match(T__27);
				setState(316);
				match(T__7);
				setState(317);
				value_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Angular_speed_exprContext extends ParserRuleContext {
		public Value_exprContext value_expr() {
			return getRuleContext(Value_exprContext.class,0);
		}
		public Angular_speed_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_angular_speed_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterAngular_speed_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitAngular_speed_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitAngular_speed_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Angular_speed_exprContext angular_speed_expr() throws RecognitionException {
		Angular_speed_exprContext _localctx = new Angular_speed_exprContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_angular_speed_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(319);
				match(T__28);
				setState(320);
				match(T__7);
				setState(321);
				value_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Ball_exprContext extends ParserRuleContext {
		public Mover_basic_propertiesContext mover_basic_properties() {
			return getRuleContext(Mover_basic_propertiesContext.class,0);
		}
		public Ball_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ball_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterBall_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitBall_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitBall_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Ball_exprContext ball_expr() throws RecognitionException {
		Ball_exprContext _localctx = new Ball_exprContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_ball_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(323);
				match(T__29);
				setState(324);
				match(T__1);
				setState(325);
				mover_basic_properties();
				setState(326);
				match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GravityContext extends ParserRuleContext {
		public Earth_exprContext earth_expr() {
			return getRuleContext(Earth_exprContext.class,0);
		}
		public Moon_exprContext moon_expr() {
			return getRuleContext(Moon_exprContext.class,0);
		}
		public GravityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gravity; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterGravity(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitGravity(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitGravity(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GravityContext gravity() throws RecognitionException {
		GravityContext _localctx = new GravityContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_gravity);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(328);
				match(T__30);
				setState(329);
				match(T__1);
				setState(330);
				earth_expr();
				setState(331);
				moon_expr();
				setState(332);
				match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Earth_exprContext extends ParserRuleContext {
		public Position_exprContext position_expr() {
			return getRuleContext(Position_exprContext.class,0);
		}
		public Earth_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_earth_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterEarth_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitEarth_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitEarth_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Earth_exprContext earth_expr() throws RecognitionException {
		Earth_exprContext _localctx = new Earth_exprContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_earth_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(334);
				match(T__31);
				setState(335);
				match(T__1);
				setState(336);
				position_expr();
				setState(337);
				match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Moon_exprContext extends ParserRuleContext {
		public Position_exprContext position_expr() {
			return getRuleContext(Position_exprContext.class,0);
		}
		public Moon_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moon_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterMoon_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitMoon_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitMoon_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Moon_exprContext moon_expr() throws RecognitionException {
		Moon_exprContext _localctx = new Moon_exprContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_moon_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(339);
				match(T__32);
				setState(340);
				match(T__1);
				setState(341);
				position_expr();
				setState(342);
				match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SpringContext extends ParserRuleContext {
		public Spring_constant_exprContext spring_constant_expr() {
			return getRuleContext(Spring_constant_exprContext.class,0);
		}
		public Damping_exprContext damping_expr() {
			return getRuleContext(Damping_exprContext.class,0);
		}
		public Spring_rest_length_exprContext spring_rest_length_expr() {
			return getRuleContext(Spring_rest_length_exprContext.class,0);
		}
		public Floor_friction_exprContext floor_friction_expr() {
			return getRuleContext(Floor_friction_exprContext.class,0);
		}
		public Ball_exprContext ball_expr() {
			return getRuleContext(Ball_exprContext.class,0);
		}
		public Spring_exprContext spring_expr() {
			return getRuleContext(Spring_exprContext.class,0);
		}
		public SpringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_spring; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterSpring(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitSpring(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitSpring(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpringContext spring() throws RecognitionException {
		SpringContext _localctx = new SpringContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_spring);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(344);
				match(T__33);
				setState(345);
				match(T__1);
				setState(346);
				spring_constant_expr();
				setState(347);
				damping_expr();
				setState(348);
				spring_rest_length_expr();
				setState(349);
				floor_friction_expr();
				setState(350);
				ball_expr();
				setState(351);
				spring_expr();
				setState(352);
				match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Spring_constant_exprContext extends ParserRuleContext {
		public Value_exprContext value_expr() {
			return getRuleContext(Value_exprContext.class,0);
		}
		public Spring_constant_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_spring_constant_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterSpring_constant_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitSpring_constant_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitSpring_constant_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Spring_constant_exprContext spring_constant_expr() throws RecognitionException {
		Spring_constant_exprContext _localctx = new Spring_constant_exprContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_spring_constant_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(354);
				match(T__34);
				setState(355);
				match(T__7);
				setState(356);
				value_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Damping_exprContext extends ParserRuleContext {
		public Value_exprContext value_expr() {
			return getRuleContext(Value_exprContext.class,0);
		}
		public Damping_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_damping_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterDamping_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitDamping_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitDamping_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Damping_exprContext damping_expr() throws RecognitionException {
		Damping_exprContext _localctx = new Damping_exprContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_damping_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(358);
				match(T__35);
				setState(359);
				match(T__7);
				setState(360);
				value_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Spring_rest_length_exprContext extends ParserRuleContext {
		public Value_exprContext value_expr() {
			return getRuleContext(Value_exprContext.class,0);
		}
		public Spring_rest_length_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_spring_rest_length_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterSpring_rest_length_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitSpring_rest_length_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitSpring_rest_length_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Spring_rest_length_exprContext spring_rest_length_expr() throws RecognitionException {
		Spring_rest_length_exprContext _localctx = new Spring_rest_length_exprContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_spring_rest_length_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(362);
				match(T__36);
				setState(363);
				match(T__7);
				setState(364);
				value_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Floor_friction_exprContext extends ParserRuleContext {
		public Value_exprContext value_expr() {
			return getRuleContext(Value_exprContext.class,0);
		}
		public Floor_friction_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_floor_friction_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterFloor_friction_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitFloor_friction_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitFloor_friction_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Floor_friction_exprContext floor_friction_expr() throws RecognitionException {
		Floor_friction_exprContext _localctx = new Floor_friction_exprContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_floor_friction_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(366);
				match(T__37);
				setState(367);
				match(T__7);
				setState(368);
				value_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Spring_exprContext extends ParserRuleContext {
		public X_anchor_position_exprContext x_anchor_position_expr() {
			return getRuleContext(X_anchor_position_exprContext.class,0);
		}
		public Y_anchor_position_exprContext y_anchor_position_expr() {
			return getRuleContext(Y_anchor_position_exprContext.class,0);
		}
		public Num_coils_exprContext num_coils_expr() {
			return getRuleContext(Num_coils_exprContext.class,0);
		}
		public Spring_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_spring_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterSpring_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitSpring_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitSpring_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Spring_exprContext spring_expr() throws RecognitionException {
		Spring_exprContext _localctx = new Spring_exprContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_spring_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(370);
				match(T__33);
				setState(371);
				match(T__1);
				setState(372);
				x_anchor_position_expr();
				setState(373);
				y_anchor_position_expr();
				setState(374);
				num_coils_expr();
				setState(375);
				match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class X_anchor_position_exprContext extends ParserRuleContext {
		public Value_exprContext value_expr() {
			return getRuleContext(Value_exprContext.class,0);
		}
		public X_anchor_position_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_x_anchor_position_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterX_anchor_position_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitX_anchor_position_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitX_anchor_position_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final X_anchor_position_exprContext x_anchor_position_expr() throws RecognitionException {
		X_anchor_position_exprContext _localctx = new X_anchor_position_exprContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_x_anchor_position_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(377);
				match(T__38);
				setState(378);
				match(T__7);
				setState(379);
				value_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Y_anchor_position_exprContext extends ParserRuleContext {
		public Value_exprContext value_expr() {
			return getRuleContext(Value_exprContext.class,0);
		}
		public Y_anchor_position_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_y_anchor_position_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterY_anchor_position_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitY_anchor_position_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitY_anchor_position_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Y_anchor_position_exprContext y_anchor_position_expr() throws RecognitionException {
		Y_anchor_position_exprContext _localctx = new Y_anchor_position_exprContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_y_anchor_position_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(381);
				match(T__39);
				setState(382);
				match(T__7);
				setState(383);
				value_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Num_coils_exprContext extends ParserRuleContext {
		public Value_exprContext value_expr() {
			return getRuleContext(Value_exprContext.class,0);
		}
		public Num_coils_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_num_coils_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterNum_coils_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitNum_coils_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitNum_coils_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Num_coils_exprContext num_coils_expr() throws RecognitionException {
		Num_coils_exprContext _localctx = new Num_coils_exprContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_num_coils_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(385);
				match(T__40);
				setState(386);
				match(T__7);
				setState(387);
				value_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PendulumContext extends ParserRuleContext {
		public Length_exprContext length_expr() {
			return getRuleContext(Length_exprContext.class,0);
		}
		public Ball_radius_exprContext ball_radius_expr() {
			return getRuleContext(Ball_radius_exprContext.class,0);
		}
		public Initial_angle_exprContext initial_angle_expr() {
			return getRuleContext(Initial_angle_exprContext.class,0);
		}
		public Angular_velocity_exprContext angular_velocity_expr() {
			return getRuleContext(Angular_velocity_exprContext.class,0);
		}
		public Angular_acceleration_exprContext angular_acceleration_expr() {
			return getRuleContext(Angular_acceleration_exprContext.class,0);
		}
		public Air_resistance_exprContext air_resistance_expr() {
			return getRuleContext(Air_resistance_exprContext.class,0);
		}
		public PendulumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pendulum; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterPendulum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitPendulum(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitPendulum(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PendulumContext pendulum() throws RecognitionException {
		PendulumContext _localctx = new PendulumContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_pendulum);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(389);
				match(T__41);
				setState(390);
				match(T__1);
				setState(391);
				length_expr();
				setState(392);
				ball_radius_expr();
				setState(393);
				initial_angle_expr();
				setState(394);
				angular_velocity_expr();
				setState(395);
				angular_acceleration_expr();
				setState(396);
				air_resistance_expr();
				setState(397);
				match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Length_exprContext extends ParserRuleContext {
		public Value_exprContext value_expr() {
			return getRuleContext(Value_exprContext.class,0);
		}
		public Length_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_length_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterLength_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitLength_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitLength_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Length_exprContext length_expr() throws RecognitionException {
		Length_exprContext _localctx = new Length_exprContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_length_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(399);
				match(T__42);
				setState(400);
				match(T__7);
				setState(401);
				value_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Ball_radius_exprContext extends ParserRuleContext {
		public Value_exprContext value_expr() {
			return getRuleContext(Value_exprContext.class,0);
		}
		public Ball_radius_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ball_radius_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterBall_radius_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitBall_radius_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitBall_radius_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Ball_radius_exprContext ball_radius_expr() throws RecognitionException {
		Ball_radius_exprContext _localctx = new Ball_radius_exprContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_ball_radius_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(403);
				match(T__43);
				setState(404);
				match(T__7);
				setState(405);
				value_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Initial_angle_exprContext extends ParserRuleContext {
		public Value_exprContext value_expr() {
			return getRuleContext(Value_exprContext.class,0);
		}
		public Initial_angle_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initial_angle_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterInitial_angle_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitInitial_angle_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitInitial_angle_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Initial_angle_exprContext initial_angle_expr() throws RecognitionException {
		Initial_angle_exprContext _localctx = new Initial_angle_exprContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_initial_angle_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(407);
				match(T__44);
				setState(408);
				match(T__7);
				setState(409);
				value_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Angular_velocity_exprContext extends ParserRuleContext {
		public Value_exprContext value_expr() {
			return getRuleContext(Value_exprContext.class,0);
		}
		public Angular_velocity_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_angular_velocity_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterAngular_velocity_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitAngular_velocity_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitAngular_velocity_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Angular_velocity_exprContext angular_velocity_expr() throws RecognitionException {
		Angular_velocity_exprContext _localctx = new Angular_velocity_exprContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_angular_velocity_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(411);
				match(T__45);
				setState(412);
				match(T__7);
				setState(413);
				value_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Angular_acceleration_exprContext extends ParserRuleContext {
		public Value_exprContext value_expr() {
			return getRuleContext(Value_exprContext.class,0);
		}
		public Angular_acceleration_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_angular_acceleration_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterAngular_acceleration_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitAngular_acceleration_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitAngular_acceleration_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Angular_acceleration_exprContext angular_acceleration_expr() throws RecognitionException {
		Angular_acceleration_exprContext _localctx = new Angular_acceleration_exprContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_angular_acceleration_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(415);
				match(T__46);
				setState(416);
				match(T__7);
				setState(417);
				value_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Air_resistance_exprContext extends ParserRuleContext {
		public Value_exprContext value_expr() {
			return getRuleContext(Value_exprContext.class,0);
		}
		public Air_resistance_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_air_resistance_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterAir_resistance_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitAir_resistance_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitAir_resistance_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Air_resistance_exprContext air_resistance_expr() throws RecognitionException {
		Air_resistance_exprContext _localctx = new Air_resistance_exprContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_air_resistance_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(419);
				match(T__47);
				setState(420);
				match(T__7);
				setState(421);
				value_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Rolling_uphillContext extends ParserRuleContext {
		public Gravitational_acceleration_exprContext gravitational_acceleration_expr() {
			return getRuleContext(Gravitational_acceleration_exprContext.class,0);
		}
		public Coefficient_of_friction_exprContext coefficient_of_friction_expr() {
			return getRuleContext(Coefficient_of_friction_exprContext.class,0);
		}
		public Bounciness_exprContext bounciness_expr() {
			return getRuleContext(Bounciness_exprContext.class,0);
		}
		public Angle_exprContext angle_expr() {
			return getRuleContext(Angle_exprContext.class,0);
		}
		public Ball_exprContext ball_expr() {
			return getRuleContext(Ball_exprContext.class,0);
		}
		public Velocity_along_incline_exprContext velocity_along_incline_expr() {
			return getRuleContext(Velocity_along_incline_exprContext.class,0);
		}
		public Rolling_uphillContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rolling_uphill; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterRolling_uphill(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitRolling_uphill(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitRolling_uphill(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Rolling_uphillContext rolling_uphill() throws RecognitionException {
		Rolling_uphillContext _localctx = new Rolling_uphillContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_rolling_uphill);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(423);
				match(T__48);
				setState(424);
				match(T__1);
				setState(425);
				gravitational_acceleration_expr();
				setState(426);
				coefficient_of_friction_expr();
				setState(427);
				bounciness_expr();
				setState(428);
				angle_expr();
				setState(429);
				ball_expr();
				setState(430);
				velocity_along_incline_expr();
				setState(431);
				match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Gravitational_acceleration_exprContext extends ParserRuleContext {
		public Value_exprContext value_expr() {
			return getRuleContext(Value_exprContext.class,0);
		}
		public Gravitational_acceleration_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gravitational_acceleration_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterGravitational_acceleration_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitGravitational_acceleration_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitGravitational_acceleration_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Gravitational_acceleration_exprContext gravitational_acceleration_expr() throws RecognitionException {
		Gravitational_acceleration_exprContext _localctx = new Gravitational_acceleration_exprContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_gravitational_acceleration_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(433);
				match(T__49);
				setState(434);
				match(T__7);
				setState(435);
				value_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Coefficient_of_friction_exprContext extends ParserRuleContext {
		public Value_exprContext value_expr() {
			return getRuleContext(Value_exprContext.class,0);
		}
		public Coefficient_of_friction_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_coefficient_of_friction_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterCoefficient_of_friction_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitCoefficient_of_friction_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitCoefficient_of_friction_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Coefficient_of_friction_exprContext coefficient_of_friction_expr() throws RecognitionException {
		Coefficient_of_friction_exprContext _localctx = new Coefficient_of_friction_exprContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_coefficient_of_friction_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(437);
				match(T__50);
				setState(438);
				match(T__7);
				setState(439);
				value_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Bounciness_exprContext extends ParserRuleContext {
		public Value_exprContext value_expr() {
			return getRuleContext(Value_exprContext.class,0);
		}
		public Bounciness_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bounciness_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterBounciness_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitBounciness_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitBounciness_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bounciness_exprContext bounciness_expr() throws RecognitionException {
		Bounciness_exprContext _localctx = new Bounciness_exprContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_bounciness_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(441);
				match(T__51);
				setState(442);
				match(T__7);
				setState(443);
				value_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Angle_exprContext extends ParserRuleContext {
		public Value_exprContext value_expr() {
			return getRuleContext(Value_exprContext.class,0);
		}
		public Angle_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_angle_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterAngle_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitAngle_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitAngle_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Angle_exprContext angle_expr() throws RecognitionException {
		Angle_exprContext _localctx = new Angle_exprContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_angle_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(445);
				match(T__52);
				setState(446);
				match(T__7);
				setState(447);
				value_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Velocity_along_incline_exprContext extends ParserRuleContext {
		public Value_exprContext value_expr() {
			return getRuleContext(Value_exprContext.class,0);
		}
		public Velocity_along_incline_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_velocity_along_incline_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterVelocity_along_incline_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitVelocity_along_incline_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitVelocity_along_incline_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Velocity_along_incline_exprContext velocity_along_incline_expr() throws RecognitionException {
		Velocity_along_incline_exprContext _localctx = new Velocity_along_incline_exprContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_velocity_along_incline_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(449);
				match(T__53);
				setState(450);
				match(T__7);
				setState(451);
				value_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Mover_basic_propertiesContext extends ParserRuleContext {
		public Radius_exprContext radius_expr() {
			return getRuleContext(Radius_exprContext.class,0);
		}
		public Color_exprContext color_expr() {
			return getRuleContext(Color_exprContext.class,0);
		}
		public Mover_basic_propertiesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mover_basic_properties; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterMover_basic_properties(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitMover_basic_properties(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitMover_basic_properties(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mover_basic_propertiesContext mover_basic_properties() throws RecognitionException {
		Mover_basic_propertiesContext _localctx = new Mover_basic_propertiesContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_mover_basic_properties);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(453);
				radius_expr();
				setState(454);
				color_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Mass_exprContext extends ParserRuleContext {
		public Value_exprContext value_expr() {
			return getRuleContext(Value_exprContext.class,0);
		}
		public Mass_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mass_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterMass_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitMass_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitMass_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mass_exprContext mass_expr() throws RecognitionException {
		Mass_exprContext _localctx = new Mass_exprContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_mass_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(456);
				match(T__54);
				setState(457);
				match(T__7);
				setState(458);
				value_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Velocity_exprContext extends ParserRuleContext {
		public X_velocity_exprContext x_velocity_expr() {
			return getRuleContext(X_velocity_exprContext.class,0);
		}
		public Y_velocity_exprContext y_velocity_expr() {
			return getRuleContext(Y_velocity_exprContext.class,0);
		}
		public Velocity_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_velocity_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterVelocity_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitVelocity_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitVelocity_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Velocity_exprContext velocity_expr() throws RecognitionException {
		Velocity_exprContext _localctx = new Velocity_exprContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_velocity_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(460);
				match(T__55);
				setState(461);
				match(T__1);
				setState(462);
				x_velocity_expr();
				setState(463);
				y_velocity_expr();
				setState(464);
				match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class X_velocity_exprContext extends ParserRuleContext {
		public Value_exprContext value_expr() {
			return getRuleContext(Value_exprContext.class,0);
		}
		public X_velocity_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_x_velocity_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterX_velocity_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitX_velocity_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitX_velocity_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final X_velocity_exprContext x_velocity_expr() throws RecognitionException {
		X_velocity_exprContext _localctx = new X_velocity_exprContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_x_velocity_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(466);
				match(T__56);
				setState(467);
				match(T__7);
				setState(468);
				value_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Y_velocity_exprContext extends ParserRuleContext {
		public Value_exprContext value_expr() {
			return getRuleContext(Value_exprContext.class,0);
		}
		public Y_velocity_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_y_velocity_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterY_velocity_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitY_velocity_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitY_velocity_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Y_velocity_exprContext y_velocity_expr() throws RecognitionException {
		Y_velocity_exprContext _localctx = new Y_velocity_exprContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_y_velocity_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(470);
				match(T__57);
				setState(471);
				match(T__7);
				setState(472);
				value_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Position_exprContext extends ParserRuleContext {
		public X_position_exprContext x_position_expr() {
			return getRuleContext(X_position_exprContext.class,0);
		}
		public Y_position_exprContext y_position_expr() {
			return getRuleContext(Y_position_exprContext.class,0);
		}
		public Position_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_position_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterPosition_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitPosition_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitPosition_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Position_exprContext position_expr() throws RecognitionException {
		Position_exprContext _localctx = new Position_exprContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_position_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(474);
				match(T__58);
				setState(475);
				match(T__1);
				setState(476);
				x_position_expr();
				setState(477);
				y_position_expr();
				setState(478);
				match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class X_position_exprContext extends ParserRuleContext {
		public Value_exprContext value_expr() {
			return getRuleContext(Value_exprContext.class,0);
		}
		public X_position_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_x_position_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterX_position_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitX_position_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitX_position_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final X_position_exprContext x_position_expr() throws RecognitionException {
		X_position_exprContext _localctx = new X_position_exprContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_x_position_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(480);
				match(T__59);
				setState(481);
				match(T__7);
				setState(482);
				value_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Y_position_exprContext extends ParserRuleContext {
		public Value_exprContext value_expr() {
			return getRuleContext(Value_exprContext.class,0);
		}
		public Y_position_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_y_position_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterY_position_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitY_position_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitY_position_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Y_position_exprContext y_position_expr() throws RecognitionException {
		Y_position_exprContext _localctx = new Y_position_exprContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_y_position_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(484);
				match(T__60);
				setState(485);
				match(T__7);
				setState(486);
				value_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Color_exprContext extends ParserRuleContext {
		public Red_value_exprContext red_value_expr() {
			return getRuleContext(Red_value_exprContext.class,0);
		}
		public Green_value_exprContext green_value_expr() {
			return getRuleContext(Green_value_exprContext.class,0);
		}
		public Blue_value_exprContext blue_value_expr() {
			return getRuleContext(Blue_value_exprContext.class,0);
		}
		public Color_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_color_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterColor_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitColor_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitColor_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Color_exprContext color_expr() throws RecognitionException {
		Color_exprContext _localctx = new Color_exprContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_color_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(488);
				match(T__61);
				setState(489);
				match(T__1);
				setState(490);
				red_value_expr();
				setState(491);
				green_value_expr();
				setState(492);
				blue_value_expr();
				setState(493);
				match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Red_value_exprContext extends ParserRuleContext {
		public Value_exprContext value_expr() {
			return getRuleContext(Value_exprContext.class,0);
		}
		public Red_value_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_red_value_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterRed_value_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitRed_value_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitRed_value_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Red_value_exprContext red_value_expr() throws RecognitionException {
		Red_value_exprContext _localctx = new Red_value_exprContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_red_value_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(495);
				match(T__62);
				setState(496);
				match(T__7);
				setState(497);
				value_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Green_value_exprContext extends ParserRuleContext {
		public Value_exprContext value_expr() {
			return getRuleContext(Value_exprContext.class,0);
		}
		public Green_value_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_green_value_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterGreen_value_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitGreen_value_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitGreen_value_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Green_value_exprContext green_value_expr() throws RecognitionException {
		Green_value_exprContext _localctx = new Green_value_exprContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_green_value_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(499);
				match(T__63);
				setState(500);
				match(T__7);
				setState(501);
				value_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Blue_value_exprContext extends ParserRuleContext {
		public Value_exprContext value_expr() {
			return getRuleContext(Value_exprContext.class,0);
		}
		public Blue_value_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blue_value_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterBlue_value_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitBlue_value_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitBlue_value_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Blue_value_exprContext blue_value_expr() throws RecognitionException {
		Blue_value_exprContext _localctx = new Blue_value_exprContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_blue_value_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(503);
				match(T__64);
				setState(504);
				match(T__7);
				setState(505);
				value_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Value_exprContext extends ParserRuleContext {
		public Simple_valueContext simple_value() {
			return getRuleContext(Simple_valueContext.class,0);
		}
		public Conditional_valueContext conditional_value() {
			return getRuleContext(Conditional_valueContext.class,0);
		}
		public Loop_valueContext loop_value() {
			return getRuleContext(Loop_valueContext.class,0);
		}
		public Value_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterValue_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitValue_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitValue_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Value_exprContext value_expr() throws RecognitionException {
		Value_exprContext _localctx = new Value_exprContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_value_expr);
		try {
			setState(510);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					enterOuterAlt(_localctx, 1);
				{
					setState(507);
					simple_value();
				}
				break;
				case 2:
					enterOuterAlt(_localctx, 2);
				{
					setState(508);
					conditional_value();
				}
				break;
				case 3:
					enterOuterAlt(_localctx, 3);
				{
					setState(509);
					loop_value();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Simple_valueContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(GravITyParser.NUMBER, 0); }
		public TerminalNode IDENTIFIER() { return getToken(GravITyParser.IDENTIFIER, 0); }
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
		}
		public Simple_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterSimple_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitSimple_value(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitSimple_value(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Simple_valueContext simple_value() throws RecognitionException {
		Simple_valueContext _localctx = new Simple_valueContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_simple_value);
		try {
			setState(515);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					enterOuterAlt(_localctx, 1);
				{
					setState(512);
					match(NUMBER);
				}
				break;
				case 2:
					enterOuterAlt(_localctx, 2);
				{
					setState(513);
					match(IDENTIFIER);
				}
				break;
				case 3:
					enterOuterAlt(_localctx, 3);
				{
					setState(514);
					reference();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Conditional_valueContext extends ParserRuleContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public List<Simple_valueContext> simple_value() {
			return getRuleContexts(Simple_valueContext.class);
		}
		public Simple_valueContext simple_value(int i) {
			return getRuleContext(Simple_valueContext.class,i);
		}
		public Conditional_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditional_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterConditional_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitConditional_value(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitConditional_value(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Conditional_valueContext conditional_value() throws RecognitionException {
		Conditional_valueContext _localctx = new Conditional_valueContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_conditional_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(517);
				match(T__65);
				setState(518);
				condition();
				setState(519);
				match(T__66);
				setState(520);
				simple_value();
				setState(521);
				match(T__67);
				setState(522);
				simple_value();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Loop_valueContext extends ParserRuleContext {
		public Initial_valueContext initial_value() {
			return getRuleContext(Initial_valueContext.class,0);
		}
		public Simple_valueContext simple_value() {
			return getRuleContext(Simple_valueContext.class,0);
		}
		public MultiplierContext multiplier() {
			return getRuleContext(MultiplierContext.class,0);
		}
		public Loop_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterLoop_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitLoop_value(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitLoop_value(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Loop_valueContext loop_value() throws RecognitionException {
		Loop_valueContext _localctx = new Loop_valueContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_loop_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(524);
				initial_value();
				setState(525);
				match(T__68);
				setState(526);
				simple_value();
				setState(527);
				match(T__69);
				setState(528);
				match(T__70);
				setState(529);
				multiplier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Initial_valueContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(GravITyParser.NUMBER, 0); }
		public Initial_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initial_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterInitial_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitInitial_value(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitInitial_value(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Initial_valueContext initial_value() throws RecognitionException {
		Initial_valueContext _localctx = new Initial_valueContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_initial_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(531);
				match(NUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MultiplierContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(GravITyParser.NUMBER, 0); }
		public Simple_valueContext simple_value() {
			return getRuleContext(Simple_valueContext.class,0);
		}
		public MultiplierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterMultiplier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitMultiplier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitMultiplier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplierContext multiplier() throws RecognitionException {
		MultiplierContext _localctx = new MultiplierContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_multiplier);
		try {
			setState(535);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					enterOuterAlt(_localctx, 1);
				{
					setState(533);
					match(NUMBER);
				}
				break;
				case 2:
					enterOuterAlt(_localctx, 2);
				{
					setState(534);
					simple_value();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConditionContext extends ParserRuleContext {
		public List<Simple_valueContext> simple_value() {
			return getRuleContexts(Simple_valueContext.class);
		}
		public Simple_valueContext simple_value(int i) {
			return getRuleContext(Simple_valueContext.class,i);
		}
		public ComparatorContext comparator() {
			return getRuleContext(ComparatorContext.class,0);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(537);
				simple_value();
				setState(538);
				comparator();
				setState(539);
				simple_value();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComparatorContext extends ParserRuleContext {
		public ComparatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterComparator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitComparator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitComparator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparatorContext comparator() throws RecognitionException {
		ComparatorContext _localctx = new ComparatorContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_comparator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(541);
				_la = _input.LA(1);
				if ( !(((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & 63L) != 0)) ) {
					_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReferenceContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(GravITyParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(GravITyParser.IDENTIFIER, i);
		}
		public ReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).enterReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GravITyListener ) ((GravITyListener)listener).exitReference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GravITyVisitor ) return ((GravITyVisitor<? extends T>)visitor).visitReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReferenceContext reference() throws RecognitionException {
		ReferenceContext _localctx = new ReferenceContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(543);
				match(IDENTIFIER);
				setState(544);
				match(T__77);
				setState(545);
				match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
			"\u0004\u0001T\u0224\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
					"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
					"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
					"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
					"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
					"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
					"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
					"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
					"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
					"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
					"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
					"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
					"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0002"+
					"-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u00071\u0002"+
					"2\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u00076\u0002"+
					"7\u00077\u00028\u00078\u00029\u00079\u0002:\u0007:\u0002;\u0007;\u0002"+
					"<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007?\u0002@\u0007@\u0002"+
					"A\u0007A\u0002B\u0007B\u0002C\u0007C\u0002D\u0007D\u0002E\u0007E\u0002"+
					"F\u0007F\u0002G\u0007G\u0002H\u0007H\u0002I\u0007I\u0002J\u0007J\u0002"+
					"K\u0007K\u0002L\u0007L\u0002M\u0007M\u0001\u0000\u0001\u0000\u0001\u0000"+
					"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
					"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
					"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002\u00b0\b\u0002"+
					"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
					"\u0004\u0004\u00b8\b\u0004\u000b\u0004\f\u0004\u00b9\u0001\u0005\u0001"+
					"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
					"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
					"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001"+
					"\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
					"\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
					"\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r"+
					"\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
					"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f"+
					"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010"+
					"\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
					"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012"+
					"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013"+
					"\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015"+
					"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016"+
					"\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
					"\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
					"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a"+
					"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b"+
					"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c"+
					"\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d"+
					"\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
					"\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001 \u0001"+
					" \u0001 \u0001 \u0001 \u0001 \u0001!\u0001!\u0001!\u0001!\u0001!\u0001"+
					"\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001#\u0001#\u0001#\u0001#\u0001#"+
					"\u0001#\u0001#\u0001#\u0001#\u0001#\u0001$\u0001$\u0001$\u0001$\u0001"+
					"%\u0001%\u0001%\u0001%\u0001&\u0001&\u0001&\u0001&\u0001\'\u0001\'\u0001"+
					"\'\u0001\'\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001)\u0001"+
					")\u0001)\u0001)\u0001*\u0001*\u0001*\u0001*\u0001+\u0001+\u0001+\u0001"+
					"+\u0001,\u0001,\u0001,\u0001,\u0001,\u0001,\u0001,\u0001,\u0001,\u0001"+
					",\u0001-\u0001-\u0001-\u0001-\u0001.\u0001.\u0001.\u0001.\u0001/\u0001"+
					"/\u0001/\u0001/\u00010\u00010\u00010\u00010\u00011\u00011\u00011\u0001"+
					"1\u00012\u00012\u00012\u00012\u00013\u00013\u00013\u00013\u00013\u0001"+
					"3\u00013\u00013\u00013\u00013\u00014\u00014\u00014\u00014\u00015\u0001"+
					"5\u00015\u00015\u00016\u00016\u00016\u00016\u00017\u00017\u00017\u0001"+
					"7\u00018\u00018\u00018\u00018\u00019\u00019\u00019\u0001:\u0001:\u0001"+
					":\u0001:\u0001;\u0001;\u0001;\u0001;\u0001;\u0001;\u0001<\u0001<\u0001"+
					"<\u0001<\u0001=\u0001=\u0001=\u0001=\u0001>\u0001>\u0001>\u0001>\u0001"+
					">\u0001>\u0001?\u0001?\u0001?\u0001?\u0001@\u0001@\u0001@\u0001@\u0001"+
					"A\u0001A\u0001A\u0001A\u0001A\u0001A\u0001A\u0001B\u0001B\u0001B\u0001"+
					"B\u0001C\u0001C\u0001C\u0001C\u0001D\u0001D\u0001D\u0001D\u0001E\u0001"+
					"E\u0001E\u0003E\u01ff\bE\u0001F\u0001F\u0001F\u0003F\u0204\bF\u0001G\u0001"+
					"G\u0001G\u0001G\u0001G\u0001G\u0001G\u0001H\u0001H\u0001H\u0001H\u0001"+
					"H\u0001H\u0001H\u0001I\u0001I\u0001J\u0001J\u0003J\u0218\bJ\u0001K\u0001"+
					"K\u0001K\u0001K\u0001L\u0001L\u0001M\u0001M\u0001M\u0001M\u0001M\u0000"+
					"\u0000N\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
					"\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080"+
					"\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098"+
					"\u009a\u0000\u0001\u0001\u0000HM\u01e6\u0000\u009c\u0001\u0000\u0000\u0000"+
					"\u0002\u00a1\u0001\u0000\u0000\u0000\u0004\u00af\u0001\u0000\u0000\u0000"+
					"\u0006\u00b1\u0001\u0000\u0000\u0000\b\u00b7\u0001\u0000\u0000\u0000\n"+
					"\u00bb\u0001\u0000\u0000\u0000\f\u00c0\u0001\u0000\u0000\u0000\u000e\u00c6"+
					"\u0001\u0000\u0000\u0000\u0010\u00cc\u0001\u0000\u0000\u0000\u0012\u00d0"+
					"\u0001\u0000\u0000\u0000\u0014\u00d4\u0001\u0000\u0000\u0000\u0016\u00db"+
					"\u0001\u0000\u0000\u0000\u0018\u00e2\u0001\u0000\u0000\u0000\u001a\u00e6"+
					"\u0001\u0000\u0000\u0000\u001c\u00ed\u0001\u0000\u0000\u0000\u001e\u00f3"+
					"\u0001\u0000\u0000\u0000 \u00f8\u0001\u0000\u0000\u0000\"\u00fd\u0001"+
					"\u0000\u0000\u0000$\u0106\u0001\u0000\u0000\u0000&\u010a\u0001\u0000\u0000"+
					"\u0000(\u010e\u0001\u0000\u0000\u0000*\u0112\u0001\u0000\u0000\u0000,"+
					"\u0116\u0001\u0000\u0000\u0000.\u011a\u0001\u0000\u0000\u00000\u0120\u0001"+
					"\u0000\u0000\u00002\u0125\u0001\u0000\u0000\u00004\u0129\u0001\u0000\u0000"+
					"\u00006\u0130\u0001\u0000\u0000\u00008\u0134\u0001\u0000\u0000\u0000:"+
					"\u013b\u0001\u0000\u0000\u0000<\u013f\u0001\u0000\u0000\u0000>\u0143\u0001"+
					"\u0000\u0000\u0000@\u0148\u0001\u0000\u0000\u0000B\u014e\u0001\u0000\u0000"+
					"\u0000D\u0153\u0001\u0000\u0000\u0000F\u0158\u0001\u0000\u0000\u0000H"+
					"\u0162\u0001\u0000\u0000\u0000J\u0166\u0001\u0000\u0000\u0000L\u016a\u0001"+
					"\u0000\u0000\u0000N\u016e\u0001\u0000\u0000\u0000P\u0172\u0001\u0000\u0000"+
					"\u0000R\u0179\u0001\u0000\u0000\u0000T\u017d\u0001\u0000\u0000\u0000V"+
					"\u0181\u0001\u0000\u0000\u0000X\u0185\u0001\u0000\u0000\u0000Z\u018f\u0001"+
					"\u0000\u0000\u0000\\\u0193\u0001\u0000\u0000\u0000^\u0197\u0001\u0000"+
					"\u0000\u0000`\u019b\u0001\u0000\u0000\u0000b\u019f\u0001\u0000\u0000\u0000"+
					"d\u01a3\u0001\u0000\u0000\u0000f\u01a7\u0001\u0000\u0000\u0000h\u01b1"+
					"\u0001\u0000\u0000\u0000j\u01b5\u0001\u0000\u0000\u0000l\u01b9\u0001\u0000"+
					"\u0000\u0000n\u01bd\u0001\u0000\u0000\u0000p\u01c1\u0001\u0000\u0000\u0000"+
					"r\u01c5\u0001\u0000\u0000\u0000t\u01c8\u0001\u0000\u0000\u0000v\u01cc"+
					"\u0001\u0000\u0000\u0000x\u01d2\u0001\u0000\u0000\u0000z\u01d6\u0001\u0000"+
					"\u0000\u0000|\u01da\u0001\u0000\u0000\u0000~\u01e0\u0001\u0000\u0000\u0000"+
					"\u0080\u01e4\u0001\u0000\u0000\u0000\u0082\u01e8\u0001\u0000\u0000\u0000"+
					"\u0084\u01ef\u0001\u0000\u0000\u0000\u0086\u01f3\u0001\u0000\u0000\u0000"+
					"\u0088\u01f7\u0001\u0000\u0000\u0000\u008a\u01fe\u0001\u0000\u0000\u0000"+
					"\u008c\u0203\u0001\u0000\u0000\u0000\u008e\u0205\u0001\u0000\u0000\u0000"+
					"\u0090\u020c\u0001\u0000\u0000\u0000\u0092\u0213\u0001\u0000\u0000\u0000"+
					"\u0094\u0217\u0001\u0000\u0000\u0000\u0096\u0219\u0001\u0000\u0000\u0000"+
					"\u0098\u021d\u0001\u0000\u0000\u0000\u009a\u021f\u0001\u0000\u0000\u0000"+
					"\u009c\u009d\u0005\u0001\u0000\u0000\u009d\u009e\u0005\u0002\u0000\u0000"+
					"\u009e\u009f\u0003\u0002\u0001\u0000\u009f\u00a0\u0005\u0003\u0000\u0000"+
					"\u00a0\u0001\u0001\u0000\u0000\u0000\u00a1\u00a2\u0003\u0004\u0002\u0000"+
					"\u00a2\u0003\u0001\u0000\u0000\u0000\u00a3\u00b0\u0003\u0006\u0003\u0000"+
					"\u00a4\u00b0\u0003\u000e\u0007\u0000\u00a5\u00b0\u0003\u0014\n\u0000\u00a6"+
					"\u00b0\u0003\u001c\u000e\u0000\u00a7\u00b0\u0003\"\u0011\u0000\u00a8\u00b0"+
					"\u0003.\u0017\u0000\u00a9\u00b0\u00034\u001a\u0000\u00aa\u00b0\u00038"+
					"\u001c\u0000\u00ab\u00b0\u0003@ \u0000\u00ac\u00b0\u0003F#\u0000\u00ad"+
					"\u00b0\u0003X,\u0000\u00ae\u00b0\u0003f3\u0000\u00af\u00a3\u0001\u0000"+
					"\u0000\u0000\u00af\u00a4\u0001\u0000\u0000\u0000\u00af\u00a5\u0001\u0000"+
					"\u0000\u0000\u00af\u00a6\u0001\u0000\u0000\u0000\u00af\u00a7\u0001\u0000"+
					"\u0000\u0000\u00af\u00a8\u0001\u0000\u0000\u0000\u00af\u00a9\u0001\u0000"+
					"\u0000\u0000\u00af\u00aa\u0001\u0000\u0000\u0000\u00af\u00ab\u0001\u0000"+
					"\u0000\u0000\u00af\u00ac\u0001\u0000\u0000\u0000\u00af\u00ad\u0001\u0000"+
					"\u0000\u0000\u00af\u00ae\u0001\u0000\u0000\u0000\u00b0\u0005\u0001\u0000"+
					"\u0000\u0000\u00b1\u00b2\u0005\u0004\u0000\u0000\u00b2\u00b3\u0005\u0002"+
					"\u0000\u0000\u00b3\u00b4\u0003\b\u0004\u0000\u00b4\u00b5\u0005\u0003\u0000"+
					"\u0000\u00b5\u0007\u0001\u0000\u0000\u0000\u00b6\u00b8\u0003\n\u0005\u0000"+
					"\u00b7\u00b6\u0001\u0000\u0000\u0000\u00b8\u00b9\u0001\u0000\u0000\u0000"+
					"\u00b9\u00b7\u0001\u0000\u0000\u0000\u00b9\u00ba\u0001\u0000\u0000\u0000"+
					"\u00ba\t\u0001\u0000\u0000\u0000\u00bb\u00bc\u0005\u0005\u0000\u0000\u00bc"+
					"\u00bd\u0005\u0002\u0000\u0000\u00bd\u00be\u0003\f\u0006\u0000\u00be\u00bf"+
					"\u0005\u0003\u0000\u0000\u00bf\u000b\u0001\u0000\u0000\u0000\u00c0\u00c1"+
					"\u0003:\u001d\u0000\u00c1\u00c2\u0003t:\u0000\u00c2\u00c3\u0003v;\u0000"+
					"\u00c3\u00c4\u0003|>\u0000\u00c4\u00c5\u0003\u0082A\u0000\u00c5\r\u0001"+
					"\u0000\u0000\u0000\u00c6\u00c7\u0005\u0006\u0000\u0000\u00c7\u00c8\u0005"+
					"\u0002\u0000\u0000\u00c8\u00c9\u0003\u0010\b\u0000\u00c9\u00ca\u0003\u0012"+
					"\t\u0000\u00ca\u00cb\u0005\u0003\u0000\u0000\u00cb\u000f\u0001\u0000\u0000"+
					"\u0000\u00cc\u00cd\u0005\u0007\u0000\u0000\u00cd\u00ce\u0005\b\u0000\u0000"+
					"\u00ce\u00cf\u0003\u008aE\u0000\u00cf\u0011\u0001\u0000\u0000\u0000\u00d0"+
					"\u00d1\u0005\t\u0000\u0000\u00d1\u00d2\u0005\b\u0000\u0000\u00d2\u00d3"+
					"\u0003\u008aE\u0000\u00d3\u0013\u0001\u0000\u0000\u0000\u00d4\u00d5\u0005"+
					"\n\u0000\u0000\u00d5\u00d6\u0005\u0002\u0000\u0000\u00d6\u00d7\u0003\u0016"+
					"\u000b\u0000\u00d7\u00d8\u0003\u0018\f\u0000\u00d8\u00d9\u0003\u001a\r"+
					"\u0000\u00d9\u00da\u0005\u0003\u0000\u0000\u00da\u0015\u0001\u0000\u0000"+
					"\u0000\u00db\u00dc\u0005\u000b\u0000\u0000\u00dc\u00dd\u0005\u0002\u0000"+
					"\u0000\u00dd\u00de\u0003\u0084B\u0000\u00de\u00df\u0003\u0086C\u0000\u00df"+
					"\u00e0\u0003\u0088D\u0000\u00e0\u00e1\u0005\u0003\u0000\u0000\u00e1\u0017"+
					"\u0001\u0000\u0000\u0000\u00e2\u00e3\u0005\f\u0000\u0000\u00e3\u00e4\u0005"+
					"\b\u0000\u0000\u00e4\u00e5\u0003\u008aE\u0000\u00e5\u0019\u0001\u0000"+
					"\u0000\u0000\u00e6\u00e7\u0005\r\u0000\u0000\u00e7\u00e8\u0005\u0002\u0000"+
					"\u0000\u00e8\u00e9\u0003\u0084B\u0000\u00e9\u00ea\u0003\u0086C\u0000\u00ea"+
					"\u00eb\u0003\u0088D\u0000\u00eb\u00ec\u0005\u0003\u0000\u0000\u00ec\u001b"+
					"\u0001\u0000\u0000\u0000\u00ed\u00ee\u0005\u000e\u0000\u0000\u00ee\u00ef"+
					"\u0005\u0002\u0000\u0000\u00ef\u00f0\u0003\u001e\u000f\u0000\u00f0\u00f1"+
					"\u0003 \u0010\u0000\u00f1\u00f2\u0005\u0003\u0000\u0000\u00f2\u001d\u0001"+
					"\u0000\u0000\u0000\u00f3\u00f4\u0005\u000f\u0000\u0000\u00f4\u00f5\u0005"+
					"\u0002\u0000\u0000\u00f5\u00f6\u0003\f\u0006\u0000\u00f6\u00f7\u0005\u0003"+
					"\u0000\u0000\u00f7\u001f\u0001\u0000\u0000\u0000\u00f8\u00f9\u0005\u0010"+
					"\u0000\u0000\u00f9\u00fa\u0005\u0002\u0000\u0000\u00fa\u00fb\u0003\f\u0006"+
					"\u0000\u00fb\u00fc\u0005\u0003\u0000\u0000\u00fc!\u0001\u0000\u0000\u0000"+
					"\u00fd\u00fe\u0005\u0011\u0000\u0000\u00fe\u00ff\u0005\u0002\u0000\u0000"+
					"\u00ff\u0100\u0003$\u0012\u0000\u0100\u0101\u0003&\u0013\u0000\u0101\u0102"+
					"\u0003(\u0014\u0000\u0102\u0103\u0003*\u0015\u0000\u0103\u0104\u0003,"+
					"\u0016\u0000\u0104\u0105\u0005\u0003\u0000\u0000\u0105#\u0001\u0000\u0000"+
					"\u0000\u0106\u0107\u0005\u0012\u0000\u0000\u0107\u0108\u0005\b\u0000\u0000"+
					"\u0108\u0109\u0003\u008aE\u0000\u0109%\u0001\u0000\u0000\u0000\u010a\u010b"+
					"\u0005\u0013\u0000\u0000\u010b\u010c\u0005\b\u0000\u0000\u010c\u010d\u0003"+
					"\u008aE\u0000\u010d\'\u0001\u0000\u0000\u0000\u010e\u010f\u0005\u0014"+
					"\u0000\u0000\u010f\u0110\u0005\b\u0000\u0000\u0110\u0111\u0003\u008aE"+
					"\u0000\u0111)\u0001\u0000\u0000\u0000\u0112\u0113\u0005\u0015\u0000\u0000"+
					"\u0113\u0114\u0005\b\u0000\u0000\u0114\u0115\u0003\u008aE\u0000\u0115"+
					"+\u0001\u0000\u0000\u0000\u0116\u0117\u0005\u0016\u0000\u0000\u0117\u0118"+
					"\u0005\b\u0000\u0000\u0118\u0119\u0003\u008aE\u0000\u0119-\u0001\u0000"+
					"\u0000\u0000\u011a\u011b\u0005\u0017\u0000\u0000\u011b\u011c\u0005\u0002"+
					"\u0000\u0000\u011c\u011d\u00030\u0018\u0000\u011d\u011e\u00032\u0019\u0000"+
					"\u011e\u011f\u0005\u0003\u0000\u0000\u011f/\u0001\u0000\u0000\u0000\u0120"+
					"\u0121\u0005\u0005\u0000\u0000\u0121\u0122\u0005\u0002\u0000\u0000\u0122"+
					"\u0123\u0003r9\u0000\u0123\u0124\u0005\u0003\u0000\u0000\u01241\u0001"+
					"\u0000\u0000\u0000\u0125\u0126\u0005\u0018\u0000\u0000\u0126\u0127\u0005"+
					"\b\u0000\u0000\u0127\u0128\u0003\u008aE\u0000\u01283\u0001\u0000\u0000"+
					"\u0000\u0129\u012a\u0005\u0019\u0000\u0000\u012a\u012b\u0005\u0002\u0000"+
					"\u0000\u012b\u012c\u00030\u0018\u0000\u012c\u012d\u00032\u0019\u0000\u012d"+
					"\u012e\u00036\u001b\u0000\u012e\u012f\u0005\u0003\u0000\u0000\u012f5\u0001"+
					"\u0000\u0000\u0000\u0130\u0131\u0005\u001a\u0000\u0000\u0131\u0132\u0005"+
					"\b\u0000\u0000\u0132\u0133\u0003\u008aE\u0000\u01337\u0001\u0000\u0000"+
					"\u0000\u0134\u0135\u0005\u001b\u0000\u0000\u0135\u0136\u0005\u0002\u0000"+
					"\u0000\u0136\u0137\u0003:\u001d\u0000\u0137\u0138\u0003<\u001e\u0000\u0138"+
					"\u0139\u0003>\u001f\u0000\u0139\u013a\u0005\u0003\u0000\u0000\u013a9\u0001"+
					"\u0000\u0000\u0000\u013b\u013c\u0005\u001c\u0000\u0000\u013c\u013d\u0005"+
					"\b\u0000\u0000\u013d\u013e\u0003\u008aE\u0000\u013e;\u0001\u0000\u0000"+
					"\u0000\u013f\u0140\u0005\u001d\u0000\u0000\u0140\u0141\u0005\b\u0000\u0000"+
					"\u0141\u0142\u0003\u008aE\u0000\u0142=\u0001\u0000\u0000\u0000\u0143\u0144"+
					"\u0005\u001e\u0000\u0000\u0144\u0145\u0005\u0002\u0000\u0000\u0145\u0146"+
					"\u0003r9\u0000\u0146\u0147\u0005\u0003\u0000\u0000\u0147?\u0001\u0000"+
					"\u0000\u0000\u0148\u0149\u0005\u001f\u0000\u0000\u0149\u014a\u0005\u0002"+
					"\u0000\u0000\u014a\u014b\u0003B!\u0000\u014b\u014c\u0003D\"\u0000\u014c"+
					"\u014d\u0005\u0003\u0000\u0000\u014dA\u0001\u0000\u0000\u0000\u014e\u014f"+
					"\u0005 \u0000\u0000\u014f\u0150\u0005\u0002\u0000\u0000\u0150\u0151\u0003"+
					"|>\u0000\u0151\u0152\u0005\u0003\u0000\u0000\u0152C\u0001\u0000\u0000"+
					"\u0000\u0153\u0154\u0005!\u0000\u0000\u0154\u0155\u0005\u0002\u0000\u0000"+
					"\u0155\u0156\u0003|>\u0000\u0156\u0157\u0005\u0003\u0000\u0000\u0157E"+
					"\u0001\u0000\u0000\u0000\u0158\u0159\u0005\"\u0000\u0000\u0159\u015a\u0005"+
					"\u0002\u0000\u0000\u015a\u015b\u0003H$\u0000\u015b\u015c\u0003J%\u0000"+
					"\u015c\u015d\u0003L&\u0000\u015d\u015e\u0003N\'\u0000\u015e\u015f\u0003"+
					">\u001f\u0000\u015f\u0160\u0003P(\u0000\u0160\u0161\u0005\u0003\u0000"+
					"\u0000\u0161G\u0001\u0000\u0000\u0000\u0162\u0163\u0005#\u0000\u0000\u0163"+
					"\u0164\u0005\b\u0000\u0000\u0164\u0165\u0003\u008aE\u0000\u0165I\u0001"+
					"\u0000\u0000\u0000\u0166\u0167\u0005$\u0000\u0000\u0167\u0168\u0005\b"+
					"\u0000\u0000\u0168\u0169\u0003\u008aE\u0000\u0169K\u0001\u0000\u0000\u0000"+
					"\u016a\u016b\u0005%\u0000\u0000\u016b\u016c\u0005\b\u0000\u0000\u016c"+
					"\u016d\u0003\u008aE\u0000\u016dM\u0001\u0000\u0000\u0000\u016e\u016f\u0005"+
					"&\u0000\u0000\u016f\u0170\u0005\b\u0000\u0000\u0170\u0171\u0003\u008a"+
					"E\u0000\u0171O\u0001\u0000\u0000\u0000\u0172\u0173\u0005\"\u0000\u0000"+
					"\u0173\u0174\u0005\u0002\u0000\u0000\u0174\u0175\u0003R)\u0000\u0175\u0176"+
					"\u0003T*\u0000\u0176\u0177\u0003V+\u0000\u0177\u0178\u0005\u0003\u0000"+
					"\u0000\u0178Q\u0001\u0000\u0000\u0000\u0179\u017a\u0005\'\u0000\u0000"+
					"\u017a\u017b\u0005\b\u0000\u0000\u017b\u017c\u0003\u008aE\u0000\u017c"+
					"S\u0001\u0000\u0000\u0000\u017d\u017e\u0005(\u0000\u0000\u017e\u017f\u0005"+
					"\b\u0000\u0000\u017f\u0180\u0003\u008aE\u0000\u0180U\u0001\u0000\u0000"+
					"\u0000\u0181\u0182\u0005)\u0000\u0000\u0182\u0183\u0005\b\u0000\u0000"+
					"\u0183\u0184\u0003\u008aE\u0000\u0184W\u0001\u0000\u0000\u0000\u0185\u0186"+
					"\u0005*\u0000\u0000\u0186\u0187\u0005\u0002\u0000\u0000\u0187\u0188\u0003"+
					"Z-\u0000\u0188\u0189\u0003\\.\u0000\u0189\u018a\u0003^/\u0000\u018a\u018b"+
					"\u0003`0\u0000\u018b\u018c\u0003b1\u0000\u018c\u018d\u0003d2\u0000\u018d"+
					"\u018e\u0005\u0003\u0000\u0000\u018eY\u0001\u0000\u0000\u0000\u018f\u0190"+
					"\u0005+\u0000\u0000\u0190\u0191\u0005\b\u0000\u0000\u0191\u0192\u0003"+
					"\u008aE\u0000\u0192[\u0001\u0000\u0000\u0000\u0193\u0194\u0005,\u0000"+
					"\u0000\u0194\u0195\u0005\b\u0000\u0000\u0195\u0196\u0003\u008aE\u0000"+
					"\u0196]\u0001\u0000\u0000\u0000\u0197\u0198\u0005-\u0000\u0000\u0198\u0199"+
					"\u0005\b\u0000\u0000\u0199\u019a\u0003\u008aE\u0000\u019a_\u0001\u0000"+
					"\u0000\u0000\u019b\u019c\u0005.\u0000\u0000\u019c\u019d\u0005\b\u0000"+
					"\u0000\u019d\u019e\u0003\u008aE\u0000\u019ea\u0001\u0000\u0000\u0000\u019f"+
					"\u01a0\u0005/\u0000\u0000\u01a0\u01a1\u0005\b\u0000\u0000\u01a1\u01a2"+
					"\u0003\u008aE\u0000\u01a2c\u0001\u0000\u0000\u0000\u01a3\u01a4\u00050"+
					"\u0000\u0000\u01a4\u01a5\u0005\b\u0000\u0000\u01a5\u01a6\u0003\u008aE"+
					"\u0000\u01a6e\u0001\u0000\u0000\u0000\u01a7\u01a8\u00051\u0000\u0000\u01a8"+
					"\u01a9\u0005\u0002\u0000\u0000\u01a9\u01aa\u0003h4\u0000\u01aa\u01ab\u0003"+
					"j5\u0000\u01ab\u01ac\u0003l6\u0000\u01ac\u01ad\u0003n7\u0000\u01ad\u01ae"+
					"\u0003>\u001f\u0000\u01ae\u01af\u0003p8\u0000\u01af\u01b0\u0005\u0003"+
					"\u0000\u0000\u01b0g\u0001\u0000\u0000\u0000\u01b1\u01b2\u00052\u0000\u0000"+
					"\u01b2\u01b3\u0005\b\u0000\u0000\u01b3\u01b4\u0003\u008aE\u0000\u01b4"+
					"i\u0001\u0000\u0000\u0000\u01b5\u01b6\u00053\u0000\u0000\u01b6\u01b7\u0005"+
					"\b\u0000\u0000\u01b7\u01b8\u0003\u008aE\u0000\u01b8k\u0001\u0000\u0000"+
					"\u0000\u01b9\u01ba\u00054\u0000\u0000\u01ba\u01bb\u0005\b\u0000\u0000"+
					"\u01bb\u01bc\u0003\u008aE\u0000\u01bcm\u0001\u0000\u0000\u0000\u01bd\u01be"+
					"\u00055\u0000\u0000\u01be\u01bf\u0005\b\u0000\u0000\u01bf\u01c0\u0003"+
					"\u008aE\u0000\u01c0o\u0001\u0000\u0000\u0000\u01c1\u01c2\u00056\u0000"+
					"\u0000\u01c2\u01c3\u0005\b\u0000\u0000\u01c3\u01c4\u0003\u008aE\u0000"+
					"\u01c4q\u0001\u0000\u0000\u0000\u01c5\u01c6\u0003:\u001d\u0000\u01c6\u01c7"+
					"\u0003\u0082A\u0000\u01c7s\u0001\u0000\u0000\u0000\u01c8\u01c9\u00057"+
					"\u0000\u0000\u01c9\u01ca\u0005\b\u0000\u0000\u01ca\u01cb\u0003\u008aE"+
					"\u0000\u01cbu\u0001\u0000\u0000\u0000\u01cc\u01cd\u00058\u0000\u0000\u01cd"+
					"\u01ce\u0005\u0002\u0000\u0000\u01ce\u01cf\u0003x<\u0000\u01cf\u01d0\u0003"+
					"z=\u0000\u01d0\u01d1\u0005\u0003\u0000\u0000\u01d1w\u0001\u0000\u0000"+
					"\u0000\u01d2\u01d3\u00059\u0000\u0000\u01d3\u01d4\u0005\b\u0000\u0000"+
					"\u01d4\u01d5\u0003\u008aE\u0000\u01d5y\u0001\u0000\u0000\u0000\u01d6\u01d7"+
					"\u0005:\u0000\u0000\u01d7\u01d8\u0005\b\u0000\u0000\u01d8\u01d9\u0003"+
					"\u008aE\u0000\u01d9{\u0001\u0000\u0000\u0000\u01da\u01db\u0005;\u0000"+
					"\u0000\u01db\u01dc\u0005\u0002\u0000\u0000\u01dc\u01dd\u0003~?\u0000\u01dd"+
					"\u01de\u0003\u0080@\u0000\u01de\u01df\u0005\u0003\u0000\u0000\u01df}\u0001"+
					"\u0000\u0000\u0000\u01e0\u01e1\u0005<\u0000\u0000\u01e1\u01e2\u0005\b"+
					"\u0000\u0000\u01e2\u01e3\u0003\u008aE\u0000\u01e3\u007f\u0001\u0000\u0000"+
					"\u0000\u01e4\u01e5\u0005=\u0000\u0000\u01e5\u01e6\u0005\b\u0000\u0000"+
					"\u01e6\u01e7\u0003\u008aE\u0000\u01e7\u0081\u0001\u0000\u0000\u0000\u01e8"+
					"\u01e9\u0005>\u0000\u0000\u01e9\u01ea\u0005\u0002\u0000\u0000\u01ea\u01eb"+
					"\u0003\u0084B\u0000\u01eb\u01ec\u0003\u0086C\u0000\u01ec\u01ed\u0003\u0088"+
					"D\u0000\u01ed\u01ee\u0005\u0003\u0000\u0000\u01ee\u0083\u0001\u0000\u0000"+
					"\u0000\u01ef\u01f0\u0005?\u0000\u0000\u01f0\u01f1\u0005\b\u0000\u0000"+
					"\u01f1\u01f2\u0003\u008aE\u0000\u01f2\u0085\u0001\u0000\u0000\u0000\u01f3"+
					"\u01f4\u0005@\u0000\u0000\u01f4\u01f5\u0005\b\u0000\u0000\u01f5\u01f6"+
					"\u0003\u008aE\u0000\u01f6\u0087\u0001\u0000\u0000\u0000\u01f7\u01f8\u0005"+
					"A\u0000\u0000\u01f8\u01f9\u0005\b\u0000\u0000\u01f9\u01fa\u0003\u008a"+
					"E\u0000\u01fa\u0089\u0001\u0000\u0000\u0000\u01fb\u01ff\u0003\u008cF\u0000"+
					"\u01fc\u01ff\u0003\u008eG\u0000\u01fd\u01ff\u0003\u0090H\u0000\u01fe\u01fb"+
					"\u0001\u0000\u0000\u0000\u01fe\u01fc\u0001\u0000\u0000\u0000\u01fe\u01fd"+
					"\u0001\u0000\u0000\u0000\u01ff\u008b\u0001\u0000\u0000\u0000\u0200\u0204"+
					"\u0005O\u0000\u0000\u0201\u0204\u0005R\u0000\u0000\u0202\u0204\u0003\u009a"+
					"M\u0000\u0203\u0200\u0001\u0000\u0000\u0000\u0203\u0201\u0001\u0000\u0000"+
					"\u0000\u0203\u0202\u0001\u0000\u0000\u0000\u0204\u008d\u0001\u0000\u0000"+
					"\u0000\u0205\u0206\u0005B\u0000\u0000\u0206\u0207\u0003\u0096K\u0000\u0207"+
					"\u0208\u0005C\u0000\u0000\u0208\u0209\u0003\u008cF\u0000\u0209\u020a\u0005"+
					"D\u0000\u0000\u020a\u020b\u0003\u008cF\u0000\u020b\u008f\u0001\u0000\u0000"+
					"\u0000\u020c\u020d\u0003\u0092I\u0000\u020d\u020e\u0005E\u0000\u0000\u020e"+
					"\u020f\u0003\u008cF\u0000\u020f\u0210\u0005F\u0000\u0000\u0210\u0211\u0005"+
					"G\u0000\u0000\u0211\u0212\u0003\u0094J\u0000\u0212\u0091\u0001\u0000\u0000"+
					"\u0000\u0213\u0214\u0005O\u0000\u0000\u0214\u0093\u0001\u0000\u0000\u0000"+
					"\u0215\u0218\u0005O\u0000\u0000\u0216\u0218\u0003\u008cF\u0000\u0217\u0215"+
					"\u0001\u0000\u0000\u0000\u0217\u0216\u0001\u0000\u0000\u0000\u0218\u0095"+
					"\u0001\u0000\u0000\u0000\u0219\u021a\u0003\u008cF\u0000\u021a\u021b\u0003"+
					"\u0098L\u0000\u021b\u021c\u0003\u008cF\u0000\u021c\u0097\u0001\u0000\u0000"+
					"\u0000\u021d\u021e\u0007\u0000\u0000\u0000\u021e\u0099\u0001\u0000\u0000"+
					"\u0000\u021f\u0220\u0005R\u0000\u0000\u0220\u0221\u0005N\u0000\u0000\u0221"+
					"\u0222\u0005R\u0000\u0000\u0222\u009b\u0001\u0000\u0000\u0000\u0005\u00af"+
					"\u00b9\u01fe\u0203\u0217";
	public static final ATN _ATN =
			new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}