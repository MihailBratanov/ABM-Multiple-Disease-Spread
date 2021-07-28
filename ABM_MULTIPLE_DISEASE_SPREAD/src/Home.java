package abm_multiple_disease_spread;

import static abm_multiple_disease_spread.SocialActivity.*;
import static com.xj.anylogic.engine.HyperArray.*;
import static com.xj.anylogic.engine.UtilitiesArray.*;
import static com.xj.anylogic.engine.presentation.UtilitiesColor.*;
import static com.xj.anylogic.engine.presentation.UtilitiesDrawing.*;
import static java.lang.Math.*;

import com.xj.anylogic.engine.*;
import com.xj.anylogic.engine.Position;
import com.xj.anylogic.engine.analysis.*;
import com.xj.anylogic.engine.connectivity.*;
import com.xj.anylogic.engine.connectivity.ResultSet;
import com.xj.anylogic.engine.connectivity.Statement;
import com.xj.anylogic.engine.markup.*;
import com.xj.anylogic.engine.markup.DensityMap;
import com.xj.anylogic.engine.markup.Network;
import com.xj.anylogic.engine.markup.PedFlowStatistics;
import com.xj.anylogic.engine.presentation.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Currency;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.Stack;
import java.util.Timer;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

public class Home extends Agent {

  // Parameters
  // Plain Variables

  public double X;
  public double Y;

  // Collection Variables
  public java.util.ArrayList<Person> members = new java.util.ArrayList<Person>();

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final short _STATECHART_ELEMENT_NEXT_ID_xjal = 0;

  // View areas
  public ViewArea _origin_VA = new ViewArea(
    this,
    "[Origin]",
    0,
    0,
    ViewArea.TOP_LEFT,
    ViewArea.SPECIFIED_ZOOM,
    1,
    100,
    100
  );

  @Override
  @AnyLogicInternalCodegenAPI
  public int getViewAreas(Map<String, ViewArea> _output) {
    if (_output != null) {
      _output.put("_origin_VA", this._origin_VA);
    }
    return 1 + super.getViewAreas(_output);
  }

  protected static final Color __ps257_Fill_Color = new Color(0xFF4F8FC8, true);
  protected static final Color __ps258_Fill_Color = new Color(0xFFA8C5E5, true);
  protected static final Color __ps259_Fill_Color = new Color(0xFF7CAAD7, true);
  protected static final Color __ps260_Fill_Color = new Color(0xFFDEEAF5, true);
  protected static final Color __ps261_Line_Color = new Color(0xFF1F2B3E, true);
  protected static final Color __ps262_Fill_Color = new Color(0xFF3C5277, true);
  protected static final Color __ps263_Fill_Color = new Color(0xFF3C5277, true);
  protected static final Color __ps264_Fill_Color = new Color(0xFF3C5277, true);
  protected static final Color __ps265_Fill_Color = new Color(0x50000000, true);

  @AnyLogicInternalCodegenAPI
  protected static final int __ps257 = 1;

  @AnyLogicInternalCodegenAPI
  protected static final int __ps258 = 2;

  @AnyLogicInternalCodegenAPI
  protected static final int __ps259 = 3;

  @AnyLogicInternalCodegenAPI
  protected static final int __ps260 = 4;

  @AnyLogicInternalCodegenAPI
  protected static final int __ps261 = 5;

  @AnyLogicInternalCodegenAPI
  protected static final int __ps262 = 6;

  @AnyLogicInternalCodegenAPI
  protected static final int __ps263 = 7;

  @AnyLogicInternalCodegenAPI
  protected static final int __ps264 = 8;

  @AnyLogicInternalCodegenAPI
  protected static final int __ps265 = 9;

  @AnyLogicInternalCodegenAPI
  protected static final int _house = 10;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = 11;

  /**
   * Top-level presentation group id
   */
  @AnyLogicInternalCodegenAPI
  protected static final int _presentation = 0;

  @AnyLogicInternalCodegenAPI
  public boolean isPublicPresentationDefined() {
    return true;
  }

  /**
   * Top-level icon group id
   */
  @AnyLogicInternalCodegenAPI
  protected static final int _icon = -1;

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps257_pointsDX_xjal() {
    return new double[] { 0.0, 12.0, 12.0, 0.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps257_pointsDY_xjal() {
    return new double[] { 0.0, -6.0, -12.0, -6.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps257_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps258_pointsDX_xjal() {
    return new double[] { 0.0, 12.0, 6.0, -6.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps258_pointsDY_xjal() {
    return new double[] { 0.0, -6.0, -12.0, -6.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps258_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps259_pointsDX_xjal() {
    return new double[] { 0.0, 0.0, 6.0, 12.0, 12.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps259_pointsDY_xjal() {
    return new double[] { 0.0, -6.0, -8.0, 0.0, 6.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps259_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0, 0.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps260_pointsDX_xjal() {
    return new double[] { 0.0, 12.0, 18.0, 6.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps260_pointsDY_xjal() {
    return new double[] { 0.0, -6.0, -6.0, 0.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps260_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps261_pointsDX_xjal() {
    return new double[] { 0.0, 12.0, 12.0, 6.0, 0.0, -12.0, -12.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps261_pointsDY_xjal() {
    return new double[] { 0.0, -6.0, -12.0, -19.0, -19.0, -12.0, -6.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps261_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps262_pointsDX_xjal() {
    return new double[] { 0.0, 2.0, 2.0, 0.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps262_pointsDY_xjal() {
    return new double[] { 0.0, 0.0, -2.0, -4.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps262_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps263_pointsDX_xjal() {
    return new double[] { 0.0, 2.0, 2.0, 0.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps263_pointsDY_xjal() {
    return new double[] { 0.0, 0.0, -4.0, -4.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps263_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps264_pointsDX_xjal() {
    return new double[] { 0.0, 2.0, 2.0, 0.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps264_pointsDY_xjal() {
    return new double[] { 0.0, 0.0, -2.0, -4.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps264_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps265_pointsDX_xjal() {
    return new double[] { 0.0, 4.0, 18.0, 12.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps265_pointsDY_xjal() {
    return new double[] { 0.0, 2.0, -4.0, -6.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps265_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0 };
  }

  ShapePolyLine _ps257;
  ShapePolyLine _ps258;
  ShapePolyLine _ps259;
  ShapePolyLine _ps260;
  ShapePolyLine _ps261;
  ShapePolyLine _ps262;
  ShapePolyLine _ps263;
  ShapePolyLine _ps264;
  ShapePolyLine _ps265;
  ShapeGroup house;

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    _ps257 =
      new ShapePolyLine(
        SHAPE_DRAW_2D,
        true,
        0.0,
        12.0,
        0.0,
        null,
        __ps257_Fill_Color,
        4,
        __ps257_pointsDX_xjal(),
        __ps257_pointsDY_xjal(),
        __ps257_pointsDZ_xjal(),
        true,
        10.0,
        1.0,
        LINE_STYLE_SOLID
      );
    _ps258 =
      new ShapePolyLine(
        SHAPE_DRAW_2D,
        true,
        0.0,
        4.0,
        0.0,
        null,
        __ps258_Fill_Color,
        4,
        __ps258_pointsDX_xjal(),
        __ps258_pointsDY_xjal(),
        __ps258_pointsDZ_xjal(),
        true,
        10.0,
        1.0,
        LINE_STYLE_SOLID
      );
    _ps259 =
      new ShapePolyLine(
        SHAPE_DRAW_2D,
        true,
        -14.0,
        6.0,
        0.0,
        null,
        __ps259_Fill_Color,
        5,
        __ps259_pointsDX_xjal(),
        __ps259_pointsDY_xjal(),
        __ps259_pointsDZ_xjal(),
        true,
        10.0,
        1.0,
        LINE_STYLE_SOLID
      );
    _ps260 =
      new ShapePolyLine(
        SHAPE_DRAW_2D,
        true,
        -14.0,
        0.0,
        0.0,
        null,
        __ps260_Fill_Color,
        4,
        __ps260_pointsDX_xjal(),
        __ps260_pointsDY_xjal(),
        __ps260_pointsDZ_xjal(),
        true,
        10.0,
        1.0,
        LINE_STYLE_SOLID
      );
    _ps261 =
      new ShapePolyLine(
        SHAPE_DRAW_2D,
        true,
        0.0,
        12.0,
        0.0,
        __ps261_Line_Color,
        null,
        7,
        __ps261_pointsDX_xjal(),
        __ps261_pointsDY_xjal(),
        __ps261_pointsDZ_xjal(),
        true,
        10.0,
        1.0,
        LINE_STYLE_SOLID
      );
    _ps262 =
      new ShapePolyLine(
        SHAPE_DRAW_2D,
        true,
        -12.0,
        4.0,
        0.0,
        null,
        __ps262_Fill_Color,
        4,
        __ps262_pointsDX_xjal(),
        __ps262_pointsDY_xjal(),
        __ps262_pointsDZ_xjal(),
        true,
        10.0,
        1.0,
        LINE_STYLE_SOLID
      );
    _ps263 =
      new ShapePolyLine(
        SHAPE_DRAW_2D,
        true,
        0.0,
        8.0,
        0.0,
        null,
        __ps263_Fill_Color,
        4,
        __ps263_pointsDX_xjal(),
        __ps263_pointsDY_xjal(),
        __ps263_pointsDZ_xjal(),
        true,
        10.0,
        1.0,
        LINE_STYLE_SOLID
      );
    _ps264 =
      new ShapePolyLine(
        SHAPE_DRAW_2D,
        true,
        -6.0,
        6.0,
        0.0,
        null,
        __ps264_Fill_Color,
        4,
        __ps264_pointsDX_xjal(),
        __ps264_pointsDY_xjal(),
        __ps264_pointsDZ_xjal(),
        true,
        10.0,
        1.0,
        LINE_STYLE_SOLID
      );
    _ps265 =
      new ShapePolyLine(
        SHAPE_DRAW_2D,
        true,
        0.0,
        12.0,
        0.0,
        null,
        __ps265_Fill_Color,
        4,
        __ps265_pointsDX_xjal(),
        __ps265_pointsDY_xjal(),
        __ps265_pointsDZ_xjal(),
        true,
        10.0,
        1.0,
        LINE_STYLE_SOLID
      );
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsAP0_xjal() {
    {
      house =
        new ShapeGroup(
          Home.this,
          SHAPE_DRAW_2D,
          true,
          0.0,
          0.0,
          0.0,
          0.0,
          _ps257,
          _ps258,
          _ps259,
          _ps260,
          _ps261,
          _ps262,
          _ps263,
          _ps264,
          _ps265
        );
    }
  }

  // Static initialization of persistent elements
  {
    _createPersistentElementsBP0_xjal();
  }

  ShapeTopLevelPresentationGroup presentation;
  ShapeGroup icon;

  @Override
  @AnyLogicInternalCodegenAPI
  public Object getPersistentShape(int _shape) {
    switch (_shape) {
      case _presentation:
        return presentation;
      case _icon:
        return icon;
      case __ps257:
        return _ps257;
      case __ps258:
        return _ps258;
      case __ps259:
        return _ps259;
      case __ps260:
        return _ps260;
      case __ps261:
        return _ps261;
      case __ps262:
        return _ps262;
      case __ps263:
        return _ps263;
      case __ps264:
        return _ps264;
      case __ps265:
        return _ps265;
      case _house:
        return house;
      default:
        return super.getPersistentShape(_shape);
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public String getNameOfShape_xjal(Object _shape) {
    try {
      if (_shape == null) return null;
      String _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, presentation, "presentation");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, icon, "icon");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, _ps257, "_ps257");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, _ps258, "_ps258");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, _ps259, "_ps259");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, _ps260, "_ps260");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, _ps261, "_ps261");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, _ps262, "_ps262");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, _ps263, "_ps263");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, _ps264, "_ps264");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, _ps265, "_ps265");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, house, "house");
      if (_name_xjal != null) return _name_xjal;
    } catch (Exception e) {
      return null;
    }
    return super.getNameOfShape_xjal(_shape);
  }

  @AnyLogicInternalCodegenAPI
  private void drawModelElements_PlainVariables_xjal(
    Panel _panel,
    Graphics2D _g,
    boolean _publicOnly,
    boolean _isSuperClass
  ) {
    if (!_publicOnly) {
      drawPlainVariable(_panel, _g, -90, 40, 10, 0, "X", X, false);
    }
    if (!_publicOnly) {
      drawPlainVariable(_panel, _g, -90, 80, 10, 0, "Y", Y, false);
    }
  }

  @AnyLogicInternalCodegenAPI
  private void drawModelElements_CollectionVariables_xjal(
    Panel _panel,
    Graphics2D _g,
    boolean _publicOnly,
    boolean _isSuperClass
  ) {
    if (!_publicOnly) {
      drawCollection(_panel, _g, 60, 30, 10, 0, "members", members);
    }
  }

  @AnyLogicInternalCodegenAPI
  private void drawModelElements_AgentLinks_xjal(
    Panel _panel,
    Graphics2D _g,
    boolean _publicOnly,
    boolean _isSuperClass
  ) {
    if (_publicOnly) {
      return;
    }
    drawLinkToContainer(_panel, _g, 50, -100, 10, 0, "main", main);
    drawLinkToAgent(
      _panel,
      _g,
      50,
      -50,
      15,
      0,
      "connections",
      true,
      connections
    );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void drawModelElements(
    Panel _panel,
    Graphics2D _g,
    boolean _publicOnly,
    boolean _isSuperClass
  ) {
    super.drawModelElements(_panel, _g, _publicOnly, true);
    drawModelElements_PlainVariables_xjal(
      _panel,
      _g,
      _publicOnly,
      _isSuperClass
    );
    drawModelElements_CollectionVariables_xjal(
      _panel,
      _g,
      _publicOnly,
      _isSuperClass
    );
    drawModelElements_AgentLinks_xjal(_panel, _g, _publicOnly, _isSuperClass);
  }

  @AnyLogicInternalCodegenAPI
  private boolean onClickModelAt_AgentLinks_xjal(
    Panel _panel,
    double _x,
    double _y,
    int _clickCount,
    boolean _publicOnly,
    boolean _isSuperClass
  ) {
    if (modelElementContains(_x, _y, 50, -100)) {
      if (_clickCount == 2) {
        _panel.browseAgent_xjal(50, -100, this, "main");
      } else {
        _panel.addInspect(50, -100, this, "main");
      }
      return true;
    }
    if (modelElementContains(_x, _y, 50, -50)) {
      _panel.addInspect_xjal(
        50,
        -50,
        this,
        "connections",
        Panel.INSPECT_CONNECTIONS_xjal
      );
      return true;
    }
    return false;
  }

  @AnyLogicInternalCodegenAPI
  private boolean onClickModelAt_PlainVariables_xjal(
    Panel _panel,
    double _x,
    double _y,
    int _clickCount,
    boolean _publicOnly,
    boolean _isSuperClass
  ) {
    if (!_publicOnly && modelElementContains(_x, _y, -90, 40)) {
      _panel.addInspect(-90, 40, this, "X");
      return true;
    }
    if (!_publicOnly && modelElementContains(_x, _y, -90, 80)) {
      _panel.addInspect(-90, 80, this, "Y");
      return true;
    }
    return false;
  }

  @AnyLogicInternalCodegenAPI
  private boolean onClickModelAt_CollectionVariables_xjal(
    Panel _panel,
    double _x,
    double _y,
    int _clickCount,
    boolean _publicOnly,
    boolean _isSuperClass
  ) {
    if (!_publicOnly && modelElementContains(_x, _y, 60, 30)) {
      _panel.addInspect(60, 30, this, "members");
      return true;
    }
    return false;
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean onClickModelAt(
    Panel _panel,
    double _x,
    double _y,
    int _clickCount,
    boolean _publicOnly,
    boolean _isSuperClass
  ) {
    if (
      onClickModelAt_AgentLinks_xjal(
        _panel,
        _x,
        _y,
        _clickCount,
        _publicOnly,
        _isSuperClass
      )
    ) {
      return true;
    }
    if (
      onClickModelAt_PlainVariables_xjal(
        _panel,
        _x,
        _y,
        _clickCount,
        _publicOnly,
        _isSuperClass
      )
    ) {
      return true;
    }
    if (
      onClickModelAt_CollectionVariables_xjal(
        _panel,
        _x,
        _y,
        _clickCount,
        _publicOnly,
        _isSuperClass
      )
    ) {
      return true;
    }
    return super.onClickModelAt(_panel, _x, _y, _clickCount, _publicOnly, true);
  }

  /**
   * Constructor
   */
  public Home(
    Engine engine,
    Agent owner,
    AgentList<? extends Home> collection
  ) {
    super(engine, owner, collection);
    if (isTopLevelClass_xjal(Home.class)) {
      instantiateBaseStructure_xjal();
    }
  }

  @AnyLogicInternalCodegenAPI
  public void onOwnerChanged_xjal() {
    super.onOwnerChanged_xjal();
    setupReferences_xjal();
  }

  @AnyLogicInternalCodegenAPI
  public void instantiateBaseStructure_xjal() {
    super.instantiateBaseStructure_xjal();
    setupReferences_xjal();
  }

  @AnyLogicInternalCodegenAPI
  private void setupReferences_xjal() {
    main = get_Main();
  }

  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function
   */
  public Home() {}

  @Override
  @AnyLogicInternalCodegenAPI
  public void create() {
    super.create();
    // Assigning initial values for plain variables
    setupPlainVariables_Home_xjal();
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
    presentation =
      new ShapeTopLevelPresentationGroup(Home.this, true, 0, 0, 0, 0, house);
    icon = new ShapeGroup(Home.this, true, 0, 0, 0);
    // Port connectors with non-replicated objects
    // Creating replicated embedded objects
    setupInitialConditions_xjal(Home.class);
    if (isTopLevelClass_xjal(Home.class)) {
      onCreate();
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void start() {
    super.start();
    if (isTopLevelClass_xjal(Home.class)) {
      onStartup();
    }
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  public void setupPlainVariables_xjal() {
    setupPlainVariables_Home_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_Home_xjal() {}

  // User API -----------------------------------------------------
  public Main get_Main() {
    {
      Agent owner = getOwner();
      if (owner instanceof Main) return (Main) owner;
    }
    return null;
  }

  /**
   * Read-only variable. <em>Shouldn't be modified by user.</em>
   */
  @AnyLogicCustomSerialization(AnyLogicCustomSerializationMode.REFERENCE)
  public transient abm_multiple_disease_spread.Main main;

  @AnyLogicInternalCodegenAPI
  static LinkToAgentAnimationSettings _connections_commonAnimationSettings_xjal = new LinkToAgentAnimationSettingsImpl(
    false,
    black,
    1.0,
    LINE_STYLE_SOLID,
    ARROW_NONE,
    0.0
  );

  public LinkToAgentCollection<Agent, Agent> connections = new LinkToAgentStandardImpl<Agent, Agent>(
    this,
    _connections_commonAnimationSettings_xjal
  );

  @Override
  public LinkToAgentCollection<? extends Agent, ? extends Agent> getLinkToAgentStandard_xjal() {
    return connections;
  }

  @AnyLogicInternalCodegenAPI
  public void drawLinksToAgents(
    boolean _underAgents_xjal,
    LinkToAgentAnimator _animator_xjal
  ) {
    super.drawLinksToAgents(_underAgents_xjal, _animator_xjal);
    if (_underAgents_xjal) {
      _animator_xjal.drawLink(this, connections, true, true);
    }
  }

  public AgentList<? extends Home> getPopulation() {
    return (AgentList<? extends Home>) super.getPopulation();
  }

  public List<? extends Home> agentsInRange(double distance) {
    return (List<? extends Home>) super.agentsInRange(distance);
  }

  /**
   * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
   */
  @AnyLogicInternalCodegenAPI
  private static final long serialVersionUID = -6908344260610046754L;
}
