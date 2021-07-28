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
import javax.swing.JApplet;

public class Simulation extends ExperimentSimulation<Main> {

  @AnyLogicInternalCodegenAPI
  public static String[] COMMAND_LINE_ARGUMENTS_xjal = new String[0];

  {
    setCommandLineArguments_xjal(COMMAND_LINE_ARGUMENTS_xjal);
  }

  // Plain Variables
  public int numHomes;
  public int numHospitals;
  public int numMarkets;
  public int numSchools;
  public int numWorkplaces;
  public int numPeople;
  public int startCovid;
  public int startFlu;
  public int duration;
  public double prog_value = 0;

  // View areas
  public ViewArea startScreen = new ViewArea(
    this,
    null,
    0,
    0,
    ViewArea.TOP_LEFT,
    ViewArea.ZOOM_TO_FIT,
    1.0,
    1500,
    800
  );
  public ViewArea paramViewArea = new ViewArea(
    this,
    null,
    0,
    1120,
    ViewArea.TOP_LEFT,
    ViewArea.ZOOM_TO_FIT,
    1.0,
    1500,
    800
  );

  @Override
  @AnyLogicInternalCodegenAPI
  public int getViewAreas(Map<String, ViewArea> _output) {
    if (_output != null) {
      _output.put("startScreen", this.startScreen);
      _output.put("paramViewArea", this.paramViewArea);
    }
    return 2 + super.getViewAreas(_output);
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void drawModelElements(
    Panel _panel,
    Graphics2D _g,
    boolean _publicOnly,
    boolean _isSuperClass
  ) {
    if (!_publicOnly) {
      drawPlainVariable(
        _panel,
        _g,
        -320,
        100,
        10,
        0,
        "numHomes",
        numHomes,
        false
      );
    }
    if (!_publicOnly) {
      drawPlainVariable(
        _panel,
        _g,
        -320,
        150,
        10,
        0,
        "numHospitals",
        numHospitals,
        false
      );
    }
    if (!_publicOnly) {
      drawPlainVariable(
        _panel,
        _g,
        -320,
        190,
        10,
        0,
        "numMarkets",
        numMarkets,
        false
      );
    }
    if (!_publicOnly) {
      drawPlainVariable(
        _panel,
        _g,
        -320,
        230,
        10,
        0,
        "numSchools",
        numSchools,
        false
      );
    }
    if (!_publicOnly) {
      drawPlainVariable(
        _panel,
        _g,
        -320,
        270,
        10,
        0,
        "numWorkplaces",
        numWorkplaces,
        false
      );
    }
    if (!_publicOnly) {
      drawPlainVariable(
        _panel,
        _g,
        -320,
        310,
        10,
        0,
        "numPeople",
        numPeople,
        false
      );
    }
    if (!_publicOnly) {
      drawPlainVariable(
        _panel,
        _g,
        -320,
        341,
        10,
        0,
        "startCovid",
        startCovid,
        false
      );
    }
    if (!_publicOnly) {
      drawPlainVariable(
        _panel,
        _g,
        -320,
        380,
        10,
        0,
        "startFlu",
        startFlu,
        false
      );
    }
    if (!_publicOnly) {
      drawPlainVariable(
        _panel,
        _g,
        -320,
        420,
        10,
        0,
        "duration",
        duration,
        false
      );
    }
    if (!_publicOnly) {
      drawPlainVariable(
        _panel,
        _g,
        1730,
        1260,
        10,
        0,
        "prog_value",
        prog_value,
        false
      );
    }
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
    if (!_publicOnly && modelElementContains(_x, _y, -320, 100)) {
      _panel.addInspect(-320, 100, this, "numHomes");
      return true;
    }
    if (!_publicOnly && modelElementContains(_x, _y, -320, 150)) {
      _panel.addInspect(-320, 150, this, "numHospitals");
      return true;
    }
    if (!_publicOnly && modelElementContains(_x, _y, -320, 190)) {
      _panel.addInspect(-320, 190, this, "numMarkets");
      return true;
    }
    if (!_publicOnly && modelElementContains(_x, _y, -320, 230)) {
      _panel.addInspect(-320, 230, this, "numSchools");
      return true;
    }
    if (!_publicOnly && modelElementContains(_x, _y, -320, 270)) {
      _panel.addInspect(-320, 270, this, "numWorkplaces");
      return true;
    }
    if (!_publicOnly && modelElementContains(_x, _y, -320, 310)) {
      _panel.addInspect(-320, 310, this, "numPeople");
      return true;
    }
    if (!_publicOnly && modelElementContains(_x, _y, -320, 341)) {
      _panel.addInspect(-320, 341, this, "startCovid");
      return true;
    }
    if (!_publicOnly && modelElementContains(_x, _y, -320, 380)) {
      _panel.addInspect(-320, 380, this, "startFlu");
      return true;
    }
    if (!_publicOnly && modelElementContains(_x, _y, -320, 420)) {
      _panel.addInspect(-320, 420, this, "duration");
      return true;
    }
    if (!_publicOnly && modelElementContains(_x, _y, 1730, 1260)) {
      _panel.addInspect(1730, 1260, this, "prog_value");
      return true;
    }
    return false;
  }

  @AnyLogicInternalCodegenAPI
  protected static final Font _editboxHomes_Font = new Font("Arial", 0, 16);

  @AnyLogicInternalCodegenAPI
  protected static final Font _editboxHospitals_Font = _editboxHomes_Font;

  @AnyLogicInternalCodegenAPI
  protected static final Font _editboxMarkets_Font = _editboxHomes_Font;

  @AnyLogicInternalCodegenAPI
  protected static final Font _editboxSchools_Font = _editboxHomes_Font;

  @AnyLogicInternalCodegenAPI
  protected static final Font _editboxWorkplaces_Font = _editboxHomes_Font;

  @AnyLogicInternalCodegenAPI
  protected static final Font _button_Font = new Font("Arial", 1, 20);

  @AnyLogicInternalCodegenAPI
  protected static final Font _editboxFlu_Font = _editboxHomes_Font;

  @AnyLogicInternalCodegenAPI
  protected static final Font _editboxCovid_Font = _editboxHomes_Font;

  @AnyLogicInternalCodegenAPI
  protected static final Font _editboxDuration_Font = _editboxHomes_Font;

  @AnyLogicInternalCodegenAPI
  protected static final Font _button1_Font = new Font("Dialog", 1, 20);

  @AnyLogicInternalCodegenAPI
  protected static final Font _text_Font = new Font("Arial", 1, 48);

  @AnyLogicInternalCodegenAPI
  protected static final Font _text1_Font = new Font("Arial", 0, 20);

  @AnyLogicInternalCodegenAPI
  protected static final Font _numHomesLabel_Font = _text1_Font;

  @AnyLogicInternalCodegenAPI
  protected static final Font _numHospitalsLabel_Font = _text1_Font;

  @AnyLogicInternalCodegenAPI
  protected static final Font _numMarketsLabel_Font = _text1_Font;

  @AnyLogicInternalCodegenAPI
  protected static final Font _numSchoolsLabel_Font = _text1_Font;

  @AnyLogicInternalCodegenAPI
  protected static final Font _numWorkplacesLabel_Font = _text1_Font;

  @AnyLogicInternalCodegenAPI
  protected static final Font _text2_Font = new Font("SansSerif", 0, 24);

  @AnyLogicInternalCodegenAPI
  protected static final Font _text3_Font = _text2_Font;

  @AnyLogicInternalCodegenAPI
  protected static final Font _loadingText_Font = new Font("SansSerif", 2, 24);

  @AnyLogicInternalCodegenAPI
  protected static final Font _numWorkplacesLabel1_Font = _text1_Font;

  @AnyLogicInternalCodegenAPI
  protected static final Font _numWorkplacesLabel2_Font = _text1_Font;

  @AnyLogicInternalCodegenAPI
  protected static final Font _numWorkplacesLabel3_Font = _text1_Font;

  @AnyLogicInternalCodegenAPI
  protected static final Font _numWorkplacesLabel4_Font = _text1_Font;

  @AnyLogicInternalCodegenAPI
  protected static final Font _numWorkplacesLabel5_Font = _text1_Font;

  @AnyLogicInternalCodegenAPI
  protected static final Font _numWorkplacesLabel6_Font = _text1_Font;

  @AnyLogicInternalCodegenAPI
  protected static final Font _numWorkplacesLabel7_Font = new Font(
    "Arial",
    2,
    20
  );

  protected static final Color _editboxHomes_Fill_Color = new Color(
    0xFFECECFB,
    true
  );
  protected static final Color _editboxHospitals_Fill_Color = new Color(
    0xFFECECFB,
    true
  );
  protected static final Color _editboxMarkets_Fill_Color = new Color(
    0xFFECECFB,
    true
  );
  protected static final Color _editboxSchools_Fill_Color = new Color(
    0xFFECECFB,
    true
  );
  protected static final Color _editboxWorkplaces_Fill_Color = new Color(
    0xFFECECFB,
    true
  );
  protected static final Color _editboxFlu_Fill_Color = new Color(
    0xFFECECFB,
    true
  );
  protected static final Color _editboxCovid_Fill_Color = new Color(
    0xFFECECFB,
    true
  );
  protected static final Color _editboxDuration_Fill_Color = new Color(
    0xFFECECFB,
    true
  );
  protected static final Color _rectangle3_Fill_Color = new Color(
    0xFFECECFB,
    true
  );
  protected static final Color _rectangle3_Line_Color = new Color(
    0xFFECECFB,
    true
  );
  protected static final Color _rectangle4_Fill_Color = new Color(
    0xFFECECFB,
    true
  );
  protected static final Color _rectangle4_Line_Color = new Color(
    0xFFECECFB,
    true
  );

  @AnyLogicInternalCodegenAPI
  protected static final int _editboxHomes = 1;

  @AnyLogicInternalCodegenAPI
  protected static final int _editboxHospitals = 2;

  @AnyLogicInternalCodegenAPI
  protected static final int _editboxMarkets = 3;

  @AnyLogicInternalCodegenAPI
  protected static final int _editboxSchools = 4;

  @AnyLogicInternalCodegenAPI
  protected static final int _editboxWorkplaces = 5;

  @AnyLogicInternalCodegenAPI
  protected static final int _button = 6;

  @AnyLogicInternalCodegenAPI
  protected static final int _editboxFlu = 7;

  @AnyLogicInternalCodegenAPI
  protected static final int _editboxCovid = 8;

  @AnyLogicInternalCodegenAPI
  protected static final int _progressBar = 9;

  @AnyLogicInternalCodegenAPI
  protected static final int _editboxDuration = 10;

  @AnyLogicInternalCodegenAPI
  protected static final int _button1 = 11;

  @AnyLogicInternalCodegenAPI
  protected static final int _image = 12;

  @AnyLogicInternalCodegenAPI
  protected static final int _text = 13;

  @AnyLogicInternalCodegenAPI
  protected static final int _image1 = 14;

  @AnyLogicInternalCodegenAPI
  protected static final int _rectangle2 = 15;

  @AnyLogicInternalCodegenAPI
  protected static final int _text1 = 16;

  @AnyLogicInternalCodegenAPI
  protected static final int _rectangle3 = 17;

  @AnyLogicInternalCodegenAPI
  protected static final int _numHomesLabel = 18;

  @AnyLogicInternalCodegenAPI
  protected static final int _numHospitalsLabel = 19;

  @AnyLogicInternalCodegenAPI
  protected static final int _numMarketsLabel = 20;

  @AnyLogicInternalCodegenAPI
  protected static final int _numSchoolsLabel = 21;

  @AnyLogicInternalCodegenAPI
  protected static final int _numWorkplacesLabel = 22;

  @AnyLogicInternalCodegenAPI
  protected static final int _dialogWindow1 = 23;

  @AnyLogicInternalCodegenAPI
  protected static final int _text2 = 24;

  @AnyLogicInternalCodegenAPI
  protected static final int _group = 25;

  @AnyLogicInternalCodegenAPI
  protected static final int _dialogWindow2 = 26;

  @AnyLogicInternalCodegenAPI
  protected static final int _text3 = 27;

  @AnyLogicInternalCodegenAPI
  protected static final int _group1 = 28;

  @AnyLogicInternalCodegenAPI
  protected static final int _group2 = 29;

  @AnyLogicInternalCodegenAPI
  protected static final int _line = 30;

  @AnyLogicInternalCodegenAPI
  protected static final int _loadingText = 31;

  @AnyLogicInternalCodegenAPI
  protected static final int _rectangle4 = 32;

  @AnyLogicInternalCodegenAPI
  protected static final int _numWorkplacesLabel1 = 33;

  @AnyLogicInternalCodegenAPI
  protected static final int _numWorkplacesLabel2 = 34;

  @AnyLogicInternalCodegenAPI
  protected static final int _numWorkplacesLabel3 = 35;

  @AnyLogicInternalCodegenAPI
  protected static final int _numWorkplacesLabel4 = 36;

  @AnyLogicInternalCodegenAPI
  protected static final int _numWorkplacesLabel5 = 37;

  @AnyLogicInternalCodegenAPI
  protected static final int _numWorkplacesLabel6 = 38;

  @AnyLogicInternalCodegenAPI
  protected static final int _numWorkplacesLabel7 = 39;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = 40;

  /**
   * Top-level presentation group id
   */
  @AnyLogicInternalCodegenAPI
  protected static final int _presentation = 0;

  /**
   * Top-level icon group id
   */
  @AnyLogicInternalCodegenAPI
  protected static final int _icon = -1;

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeShapeControlAction(int _shape, int index) {
    switch (_shape) {
      case _button:
        {
          ShapeButton self = this.button;
          progressBar.setDeterminate(false);

          if (getState() == IDLE) {
            run();
            getPresentation().setPresentable(getEngine().getRoot());
          }
        }
        break;
      case _button1:
        {
          ShapeButton self = this.button1;
          paramViewArea.navigateTo();
          loadingText.setText("");
          //progressBar.setVisible(false);


        }
        break;
      default:
        super.executeShapeControlAction(_shape, index);
        break;
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeShapeControlAction(int _shape, int index, String value) {
    switch (_shape) {
      case _editboxHomes:
        numHomes = Integer.parseInt(value);
        break;
      case _editboxHospitals:
        numHospitals = Integer.parseInt(value);
        break;
      case _editboxMarkets:
        numMarkets = Integer.parseInt(value);
        break;
      case _editboxSchools:
        numSchools = Integer.parseInt(value);
        break;
      case _editboxWorkplaces:
        numWorkplaces = Integer.parseInt(value);
        break;
      case _editboxFlu:
        startFlu = Integer.parseInt(value);
        break;
      case _editboxCovid:
        startCovid = Integer.parseInt(value);
        break;
      case _editboxDuration:
        duration = Integer.parseInt(value);
        break;
      default:
        super.executeShapeControlAction(_shape, index, value);
        break;
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public double getShapeControlMinimum(int _shape, int index) {
    switch (_shape) {
      case _editboxHomes:
        return 1;
      case _editboxHospitals:
        return 1;
      case _editboxMarkets:
        return 1;
      case _editboxSchools:
        return 1;
      case _editboxWorkplaces:
        return 1;
      case _editboxFlu:
        return 1;
      case _editboxCovid:
        return 1;
      case _editboxDuration:
        return Integer.MIN_VALUE;
      default:
        return super.getShapeControlMinimum(_shape, index);
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public double getShapeControlMaximum(int _shape, int index) {
    switch (_shape) {
      case _editboxHomes:
        return Integer.MAX_VALUE;
      case _editboxHospitals:
        return Integer.MAX_VALUE;
      case _editboxMarkets:
        return Integer.MAX_VALUE;
      case _editboxSchools:
        return Integer.MAX_VALUE;
      case _editboxWorkplaces:
        return Integer.MAX_VALUE;
      case _editboxFlu:
        return Integer.MAX_VALUE;
      case _editboxCovid:
        return Integer.MAX_VALUE;
      case _editboxDuration:
        return Integer.MAX_VALUE;
      default:
        return super.getShapeControlMaximum(_shape, index);
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public String getShapeControlDefaultValueString(int _shape, int index) {
    switch (_shape) {
      case _editboxHomes:
        return String.valueOf(numHomes);
      case _editboxHospitals:
        return String.valueOf(numHospitals);
      case _editboxMarkets:
        return String.valueOf(numMarkets);
      case _editboxSchools:
        return String.valueOf(numSchools);
      case _editboxWorkplaces:
        return String.valueOf(numWorkplaces);
      case _editboxFlu:
        return String.valueOf(startFlu);
      case _editboxCovid:
        return String.valueOf(startCovid);
      case _editboxDuration:
        return String.valueOf(duration);
      default:
        return super.getShapeControlDefaultValueString(_shape, index);
    }
  }

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _editboxHomes_SetDynamicParams_xjal(ShapeTextField shape) {
    shape.setRange(
      getShapeControlMinimum(_editboxHomes),
      getShapeControlMaximum(_editboxHomes)
    );
  }

  ShapeTextField editboxHomes;

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _editboxHospitals_SetDynamicParams_xjal(ShapeTextField shape) {
    shape.setRange(
      getShapeControlMinimum(_editboxHospitals),
      getShapeControlMaximum(_editboxHospitals)
    );
  }

  ShapeTextField editboxHospitals;

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _editboxMarkets_SetDynamicParams_xjal(ShapeTextField shape) {
    shape.setRange(
      getShapeControlMinimum(_editboxMarkets),
      getShapeControlMaximum(_editboxMarkets)
    );
  }

  ShapeTextField editboxMarkets;

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _editboxSchools_SetDynamicParams_xjal(ShapeTextField shape) {
    shape.setRange(
      getShapeControlMinimum(_editboxSchools),
      getShapeControlMaximum(_editboxSchools)
    );
  }

  ShapeTextField editboxSchools;

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _editboxWorkplaces_SetDynamicParams_xjal(ShapeTextField shape) {
    shape.setRange(
      getShapeControlMinimum(_editboxWorkplaces),
      getShapeControlMaximum(_editboxWorkplaces)
    );
  }

  ShapeTextField editboxWorkplaces;
  ShapeButton button;

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _editboxFlu_SetDynamicParams_xjal(ShapeTextField shape) {
    shape.setRange(
      getShapeControlMinimum(_editboxFlu),
      getShapeControlMaximum(_editboxFlu)
    );
  }

  ShapeTextField editboxFlu;

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _editboxCovid_SetDynamicParams_xjal(ShapeTextField shape) {
    shape.setRange(
      getShapeControlMinimum(_editboxCovid),
      getShapeControlMaximum(_editboxCovid)
    );
  }

  ShapeTextField editboxCovid;

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _progressBar_SetDynamicParams_xjal(ShapeProgressBar shape) {
    {
      @AnyLogicInternalCodegenAPI
      double _min = 0;
      @AnyLogicInternalCodegenAPI
      double _max = 100;
      shape.setRange(_min, _max);
    }
    shape.setValue(prog_value);
    shape.setProgressString(null);
    shape.setDeterminate(true);
  }

  ShapeProgressBar progressBar;

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _editboxDuration_SetDynamicParams_xjal(ShapeTextField shape) {
    shape.setRange(
      getShapeControlMinimum(_editboxDuration),
      getShapeControlMaximum(_editboxDuration)
    );
  }

  ShapeTextField editboxDuration;
  ShapeButton button1;
  ShapeImage image;
  ShapeText text;
  ShapeImage image1;
  ShapeRectangle rectangle2;
  ShapeText text1;
  ShapeRectangle rectangle3;
  ShapeText numHomesLabel;
  ShapeText numHospitalsLabel;
  ShapeText numMarketsLabel;
  ShapeText numSchoolsLabel;
  ShapeText numWorkplacesLabel;
  ShapeRoundedRectangle dialogWindow1;
  ShapeText text2;
  ShapeGroup group;
  ShapeRoundedRectangle dialogWindow2;
  ShapeText text3;
  ShapeGroup group1;
  ShapeGroup group2;
  ShapeLine line;
  ShapeText loadingText;
  ShapeRectangle rectangle4;
  ShapeText numWorkplacesLabel1;
  ShapeText numWorkplacesLabel2;
  ShapeText numWorkplacesLabel3;
  ShapeText numWorkplacesLabel4;
  ShapeText numWorkplacesLabel5;
  ShapeText numWorkplacesLabel6;
  ShapeText numWorkplacesLabel7;

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    editboxHomes =
      new ShapeTextField(
        Simulation.this,
        true,
        290.0,
        1350.0,
        180.0,
        30.0,
        _editboxHomes_Fill_Color,
        controlDefault,
        _editboxHomes_Font,
        ShapeControl.TYPE_INT,
        getShapeControlMinimum(_editboxHomes),
        getShapeControlMaximum(_editboxHomes)
      ) {
        @Override
        public void updateDynamicProperties(boolean publicOnly) {
          _editboxHomes_SetDynamicParams_xjal(this);
          super.updateDynamicProperties(publicOnly);
        }

        @Override
        @AnyLogicInternalCodegenAPI
        public void action() {
          executeShapeControlAction(_editboxHomes, 0, value);
        }

        @Override
        public void setValueToDefault() {
          setText(getShapeControlDefaultValueString(_editboxHomes, 0));
        }

        /**
         * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
         */
        @AnyLogicInternalCodegenAPI
        private static final long serialVersionUID = -9079103501712031172L;
      };
    editboxHospitals =
      new ShapeTextField(
        Simulation.this,
        true,
        290.0,
        1420.0,
        180.0,
        30.0,
        _editboxHospitals_Fill_Color,
        controlDefault,
        _editboxHospitals_Font,
        ShapeControl.TYPE_INT,
        getShapeControlMinimum(_editboxHospitals),
        getShapeControlMaximum(_editboxHospitals)
      ) {
        @Override
        public void updateDynamicProperties(boolean publicOnly) {
          _editboxHospitals_SetDynamicParams_xjal(this);
          super.updateDynamicProperties(publicOnly);
        }

        @Override
        @AnyLogicInternalCodegenAPI
        public void action() {
          executeShapeControlAction(_editboxHospitals, 0, value);
        }

        @Override
        public void setValueToDefault() {
          setText(getShapeControlDefaultValueString(_editboxHospitals, 0));
        }

        /**
         * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
         */
        @AnyLogicInternalCodegenAPI
        private static final long serialVersionUID = -9079103501712031172L;
      };
    editboxMarkets =
      new ShapeTextField(
        Simulation.this,
        true,
        290.0,
        1480.0,
        180.0,
        30.0,
        _editboxMarkets_Fill_Color,
        controlDefault,
        _editboxMarkets_Font,
        ShapeControl.TYPE_INT,
        getShapeControlMinimum(_editboxMarkets),
        getShapeControlMaximum(_editboxMarkets)
      ) {
        @Override
        public void updateDynamicProperties(boolean publicOnly) {
          _editboxMarkets_SetDynamicParams_xjal(this);
          super.updateDynamicProperties(publicOnly);
        }

        @Override
        @AnyLogicInternalCodegenAPI
        public void action() {
          executeShapeControlAction(_editboxMarkets, 0, value);
        }

        @Override
        public void setValueToDefault() {
          setText(getShapeControlDefaultValueString(_editboxMarkets, 0));
        }

        /**
         * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
         */
        @AnyLogicInternalCodegenAPI
        private static final long serialVersionUID = -9079103501712031192L;
      };
    editboxSchools =
      new ShapeTextField(
        Simulation.this,
        true,
        290.0,
        1540.0,
        180.0,
        30.0,
        _editboxSchools_Fill_Color,
        controlDefault,
        _editboxSchools_Font,
        ShapeControl.TYPE_INT,
        getShapeControlMinimum(_editboxSchools),
        getShapeControlMaximum(_editboxSchools)
      ) {
        @Override
        public void updateDynamicProperties(boolean publicOnly) {
          _editboxSchools_SetDynamicParams_xjal(this);
          super.updateDynamicProperties(publicOnly);
        }

        @Override
        @AnyLogicInternalCodegenAPI
        public void action() {
          executeShapeControlAction(_editboxSchools, 0, value);
        }

        @Override
        public void setValueToDefault() {
          setText(getShapeControlDefaultValueString(_editboxSchools, 0));
        }

        /**
         * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
         */
        @AnyLogicInternalCodegenAPI
        private static final long serialVersionUID = -9079103501712031192L;
      };
    editboxWorkplaces =
      new ShapeTextField(
        Simulation.this,
        true,
        290.0,
        1600.0,
        180.0,
        30.0,
        _editboxWorkplaces_Fill_Color,
        controlDefault,
        _editboxWorkplaces_Font,
        ShapeControl.TYPE_INT,
        getShapeControlMinimum(_editboxWorkplaces),
        getShapeControlMaximum(_editboxWorkplaces)
      ) {
        @Override
        public void updateDynamicProperties(boolean publicOnly) {
          _editboxWorkplaces_SetDynamicParams_xjal(this);
          super.updateDynamicProperties(publicOnly);
        }

        @Override
        @AnyLogicInternalCodegenAPI
        public void action() {
          executeShapeControlAction(_editboxWorkplaces, 0, value);
        }

        @Override
        public void setValueToDefault() {
          setText(getShapeControlDefaultValueString(_editboxWorkplaces, 0));
        }

        /**
         * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
         */
        @AnyLogicInternalCodegenAPI
        private static final long serialVersionUID = -9079103501712031188L;
      };
    button =
      new ShapeButton(
        Simulation.this,
        true,
        1350.0,
        1870.0,
        120.0,
        40.0,
        white,
        blue,
        _button_Font,
        "START"
      ) {
        @Override
        @AnyLogicInternalCodegenAPI
        public void action() {
          executeShapeControlAction(_button, 0);
        }

        /**
         * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
         */
        @AnyLogicInternalCodegenAPI
        private static final long serialVersionUID = -9079103501532724679L;
      };
    editboxFlu =
      new ShapeTextField(
        Simulation.this,
        true,
        290.0,
        1660.0,
        180.0,
        30.0,
        _editboxFlu_Fill_Color,
        controlDefault,
        _editboxFlu_Font,
        ShapeControl.TYPE_INT,
        getShapeControlMinimum(_editboxFlu),
        getShapeControlMaximum(_editboxFlu)
      ) {
        @Override
        public void updateDynamicProperties(boolean publicOnly) {
          _editboxFlu_SetDynamicParams_xjal(this);
          super.updateDynamicProperties(publicOnly);
        }

        @Override
        @AnyLogicInternalCodegenAPI
        public void action() {
          executeShapeControlAction(_editboxFlu, 0, value);
        }

        @Override
        public void setValueToDefault() {
          setText(getShapeControlDefaultValueString(_editboxFlu, 0));
        }

        /**
         * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
         */
        @AnyLogicInternalCodegenAPI
        private static final long serialVersionUID = -9079103522990778840L;
      };
    editboxCovid =
      new ShapeTextField(
        Simulation.this,
        true,
        290.0,
        1710.0,
        180.0,
        30.0,
        _editboxCovid_Fill_Color,
        controlDefault,
        _editboxCovid_Font,
        ShapeControl.TYPE_INT,
        getShapeControlMinimum(_editboxCovid),
        getShapeControlMaximum(_editboxCovid)
      ) {
        @Override
        public void updateDynamicProperties(boolean publicOnly) {
          _editboxCovid_SetDynamicParams_xjal(this);
          super.updateDynamicProperties(publicOnly);
        }

        @Override
        @AnyLogicInternalCodegenAPI
        public void action() {
          executeShapeControlAction(_editboxCovid, 0, value);
        }

        @Override
        public void setValueToDefault() {
          setText(getShapeControlDefaultValueString(_editboxCovid, 0));
        }

        /**
         * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
         */
        @AnyLogicInternalCodegenAPI
        private static final long serialVersionUID = -9079103522990520455L;
      };
    progressBar =
      new ShapeProgressBar(
        Simulation.this,
        true,
        1110.0,
        1880.0,
        200.0,
        20.0,
        controlDefault,
        false,
        0,
        100
      ) {
        @Override
        public void updateDynamicProperties(boolean publicOnly) {
          _progressBar_SetDynamicParams_xjal(this);
          super.updateDynamicProperties(publicOnly);
        }

        /**
         * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
         */
        @AnyLogicInternalCodegenAPI
        private static final long serialVersionUID = -9079103522985606343L;
      };
    editboxDuration =
      new ShapeTextField(
        Simulation.this,
        true,
        290.0,
        1760.0,
        180.0,
        30.0,
        _editboxDuration_Fill_Color,
        controlDefault,
        _editboxDuration_Font,
        ShapeControl.TYPE_INT,
        getShapeControlMinimum(_editboxDuration),
        getShapeControlMaximum(_editboxDuration)
      ) {
        @Override
        public void updateDynamicProperties(boolean publicOnly) {
          _editboxDuration_SetDynamicParams_xjal(this);
          super.updateDynamicProperties(publicOnly);
        }

        @Override
        @AnyLogicInternalCodegenAPI
        public void action() {
          executeShapeControlAction(_editboxDuration, 0, value);
        }

        @Override
        public void setValueToDefault() {
          setText(getShapeControlDefaultValueString(_editboxDuration, 0));
        }

        /**
         * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
         */
        @AnyLogicInternalCodegenAPI
        private static final long serialVersionUID = -9079103523007539587L;
      };
    button1 =
      new ShapeButton(
        Simulation.this,
        true,
        -55.0,
        111.0,
        138.0,
        41.0,
        white,
        indigo,
        _button1_Font,
        "OK"
      ) {
        @Override
        @AnyLogicInternalCodegenAPI
        public void action() {
          executeShapeControlAction(_button1, 0);
        }

        /**
         * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
         */
        @AnyLogicInternalCodegenAPI
        private static final long serialVersionUID = -9079103501531412628L;
      };
    image =
      new ShapeImage(
        Simulation.this,
        SHAPE_DRAW_2D,
        true,
        0.0,
        0.0,
        0.0,
        0.0,
        1500.0,
        800.0,
        "/abm_multiple_disease_spread/",
        new String[] { "File_000.jpeg" }
      );
    text =
      new ShapeText(
        SHAPE_DRAW_2D,
        true,
        780.0,
        100.0,
        0.0,
        0.0,
        white,
        "Multiple disease spread simulation\r\n",
        _text_Font,
        ALIGNMENT_CENTER
      );
    image1 =
      new ShapeImage(
        Simulation.this,
        SHAPE_DRAW_2D,
        true,
        0.0,
        1120.0,
        0.0,
        0.0,
        1500.0,
        800.0,
        "/abm_multiple_disease_spread/",
        new String[] { "File_000.jpeg" }
      );
    rectangle2 =
      new ShapeRectangle(
        SHAPE_DRAW_2D,
        true,
        10.0,
        1230.0,
        0.0,
        0.0,
        black,
        white,
        1480.0,
        600.0,
        10.0,
        1.0,
        LINE_STYLE_SOLID
      );
    text1 =
      new ShapeText(
        SHAPE_DRAW_2D,
        true,
        250.0,
        1280.0,
        0.0,
        0.0,
        black,
        "Please choose parameters for the simulation:",
        _text1_Font,
        ALIGNMENT_CENTER
      );
    rectangle3 =
      new ShapeRectangle(
        SHAPE_DRAW_2D,
        true,
        0.0,
        1120.0,
        0.0,
        0.0,
        _rectangle3_Line_Color,
        _rectangle3_Fill_Color,
        1500.0,
        60.0,
        10.0,
        1.0,
        LINE_STYLE_SOLID
      );
    numHomesLabel =
      new ShapeText(
        SHAPE_DRAW_2D,
        true,
        70.0,
        1350.0,
        0.0,
        0.0,
        black,
        "Number of homes:",
        _numHomesLabel_Font,
        ALIGNMENT_LEFT
      );
    numHospitalsLabel =
      new ShapeText(
        SHAPE_DRAW_2D,
        true,
        70.0,
        1420.0,
        0.0,
        0.0,
        black,
        "Number of hospitals:",
        _numHospitalsLabel_Font,
        ALIGNMENT_LEFT
      );
    numMarketsLabel =
      new ShapeText(
        SHAPE_DRAW_2D,
        true,
        70.0,
        1480.0,
        0.0,
        0.0,
        black,
        "Number of social places:",
        _numMarketsLabel_Font,
        ALIGNMENT_LEFT
      );
    numSchoolsLabel =
      new ShapeText(
        SHAPE_DRAW_2D,
        true,
        70.0,
        1540.0,
        0.0,
        0.0,
        black,
        "Number of schools:",
        _numSchoolsLabel_Font,
        ALIGNMENT_LEFT
      );
    numWorkplacesLabel =
      new ShapeText(
        SHAPE_DRAW_2D,
        true,
        70.0,
        1600.0,
        0.0,
        0.0,
        black,
        "Number of workplaces:",
        _numWorkplacesLabel_Font,
        ALIGNMENT_LEFT
      );
    dialogWindow1 =
      new ShapeRoundedRectangle(
        true,
        -300.0,
        -200.0,
        0.0,
        black,
        white,
        620.0,
        300.0,
        10.0,
        1.0,
        LINE_STYLE_SOLID
      );
    text2 =
      new ShapeText(
        SHAPE_DRAW_2D,
        true,
        10.0,
        -120.0,
        0.0,
        0.0,
        indigo,
        "This is an agent-based modelling simulation,\r\naimed to demonstrate the spread of multiple \r\ninfectious diseases.\r\nTo begin press OK. ",
        _text2_Font,
        ALIGNMENT_CENTER
      );
    dialogWindow2 =
      new ShapeRoundedRectangle(
        true,
        -322.0,
        -202.0,
        0.0,
        indigo,
        white,
        675.0,
        460.0,
        10.0,
        1.0,
        LINE_STYLE_SOLID
      );
    text3 =
      new ShapeText(
        SHAPE_DRAW_2D,
        true,
        -298.0,
        -141.0,
        0.0,
        0.0,
        black,
        "This is an agent based model to simulate\r\n a potential \"twindemic\"event. \r\nThe model includes the infamous SARS-COV-2 \r\ncoronavirus also known as COVID-19\r\nand a normal seasonal inflluenza virus \r\nthat usually occurs each year.  The model \r\nperforms best with up to 10 000 homes. Each home\r\nrepresents a family of up to 5 people. \r\nPlease note that every time you stop the simulation, \r\nresults have been saved to the default folder. \r\nMake sure that the excel file is closed before running the\r\nmodel. Please allow some time for the simulation to load.\r\n",
        _text3_Font,
        ALIGNMENT_LEFT
      );
    line =
      new ShapeLine(
        SHAPE_DRAW_2D,
        true,
        50.0,
        1320.0,
        0.0,
        silver,
        400.0,
        0.0,
        0.0,
        2.0,
        10.0,
        LINE_STYLE_SOLID
      );
    loadingText =
      new ShapeText(
        SHAPE_DRAW_2D,
        true,
        1050.0,
        1790.0,
        0.0,
        0.0,
        indigo,
        " ",
        _loadingText_Font,
        ALIGNMENT_LEFT
      );
    rectangle4 =
      new ShapeRectangle(
        SHAPE_DRAW_2D,
        true,
        0.0,
        1860.0,
        0.0,
        0.0,
        _rectangle4_Line_Color,
        _rectangle4_Fill_Color,
        1500.0,
        60.0,
        10.0,
        1.0,
        LINE_STYLE_SOLID
      );
    numWorkplacesLabel1 =
      new ShapeText(
        SHAPE_DRAW_2D,
        true,
        70.0,
        1660.0,
        0.0,
        0.0,
        black,
        "Introduce flu after:",
        _numWorkplacesLabel1_Font,
        ALIGNMENT_LEFT
      );
    numWorkplacesLabel2 =
      new ShapeText(
        SHAPE_DRAW_2D,
        true,
        70.0,
        1710.0,
        0.0,
        0.0,
        black,
        "Introduce covid after:",
        _numWorkplacesLabel2_Font,
        ALIGNMENT_LEFT
      );
    numWorkplacesLabel3 =
      new ShapeText(
        SHAPE_DRAW_2D,
        true,
        490.0,
        1660.0,
        0.0,
        0.0,
        black,
        "Days",
        _numWorkplacesLabel3_Font,
        ALIGNMENT_LEFT
      );
    numWorkplacesLabel4 =
      new ShapeText(
        SHAPE_DRAW_2D,
        true,
        490.0,
        1710.0,
        0.0,
        0.0,
        black,
        "Days",
        _numWorkplacesLabel4_Font,
        ALIGNMENT_LEFT
      );
    numWorkplacesLabel5 =
      new ShapeText(
        SHAPE_DRAW_2D,
        true,
        70.0,
        1760.0,
        0.0,
        0.0,
        black,
        "Run simulation for:",
        _numWorkplacesLabel5_Font,
        ALIGNMENT_LEFT
      );
    numWorkplacesLabel6 =
      new ShapeText(
        SHAPE_DRAW_2D,
        true,
        490.0,
        1760.0,
        0.0,
        0.0,
        black,
        "Days",
        _numWorkplacesLabel6_Font,
        ALIGNMENT_LEFT
      );
    numWorkplacesLabel7 =
      new ShapeText(
        SHAPE_DRAW_2D,
        true,
        550.0,
        1760.0,
        0.0,
        0.0,
        gray,
        "(default 0 means unlimited time)",
        _numWorkplacesLabel7_Font,
        ALIGNMENT_LEFT
      );
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsAP0_xjal() {
    {
      group =
        new ShapeGroup(
          Simulation.this,
          SHAPE_DRAW_2D,
          true,
          740.0,
          410.0,
          0.0,
          0.0,
          dialogWindow1,
          text2,
          button1
        );
    }
    {
      group1 =
        new ShapeGroup(
          Simulation.this,
          SHAPE_DRAW_2D,
          true,
          40.0,
          -80.0,
          0.0,
          0.0,
          dialogWindow2,
          text3
        );
    }
    {
      group2 =
        new ShapeGroup(
          Simulation.this,
          SHAPE_DRAW_2D,
          true,
          970.0,
          1480.0,
          0.0,
          0.0,
          group1
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
      case _editboxHomes:
        return editboxHomes;
      case _editboxHospitals:
        return editboxHospitals;
      case _editboxMarkets:
        return editboxMarkets;
      case _editboxSchools:
        return editboxSchools;
      case _editboxWorkplaces:
        return editboxWorkplaces;
      case _button:
        return button;
      case _editboxFlu:
        return editboxFlu;
      case _editboxCovid:
        return editboxCovid;
      case _progressBar:
        return progressBar;
      case _editboxDuration:
        return editboxDuration;
      case _button1:
        return button1;
      case _image:
        return image;
      case _text:
        return text;
      case _image1:
        return image1;
      case _rectangle2:
        return rectangle2;
      case _text1:
        return text1;
      case _rectangle3:
        return rectangle3;
      case _numHomesLabel:
        return numHomesLabel;
      case _numHospitalsLabel:
        return numHospitalsLabel;
      case _numMarketsLabel:
        return numMarketsLabel;
      case _numSchoolsLabel:
        return numSchoolsLabel;
      case _numWorkplacesLabel:
        return numWorkplacesLabel;
      case _dialogWindow1:
        return dialogWindow1;
      case _text2:
        return text2;
      case _group:
        return group;
      case _dialogWindow2:
        return dialogWindow2;
      case _text3:
        return text3;
      case _group1:
        return group1;
      case _group2:
        return group2;
      case _line:
        return line;
      case _loadingText:
        return loadingText;
      case _rectangle4:
        return rectangle4;
      case _numWorkplacesLabel1:
        return numWorkplacesLabel1;
      case _numWorkplacesLabel2:
        return numWorkplacesLabel2;
      case _numWorkplacesLabel3:
        return numWorkplacesLabel3;
      case _numWorkplacesLabel4:
        return numWorkplacesLabel4;
      case _numWorkplacesLabel5:
        return numWorkplacesLabel5;
      case _numWorkplacesLabel6:
        return numWorkplacesLabel6;
      case _numWorkplacesLabel7:
        return numWorkplacesLabel7;
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
      _name_xjal = checkNameOfShape_xjal(_shape, editboxHomes, "editboxHomes");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal =
        checkNameOfShape_xjal(_shape, editboxHospitals, "editboxHospitals");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal =
        checkNameOfShape_xjal(_shape, editboxMarkets, "editboxMarkets");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal =
        checkNameOfShape_xjal(_shape, editboxSchools, "editboxSchools");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal =
        checkNameOfShape_xjal(_shape, editboxWorkplaces, "editboxWorkplaces");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, button, "button");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, editboxFlu, "editboxFlu");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, editboxCovid, "editboxCovid");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, progressBar, "progressBar");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal =
        checkNameOfShape_xjal(_shape, editboxDuration, "editboxDuration");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, button1, "button1");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, image, "image");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, text, "text");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, image1, "image1");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, rectangle2, "rectangle2");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, text1, "text1");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, rectangle3, "rectangle3");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal =
        checkNameOfShape_xjal(_shape, numHomesLabel, "numHomesLabel");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal =
        checkNameOfShape_xjal(_shape, numHospitalsLabel, "numHospitalsLabel");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal =
        checkNameOfShape_xjal(_shape, numMarketsLabel, "numMarketsLabel");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal =
        checkNameOfShape_xjal(_shape, numSchoolsLabel, "numSchoolsLabel");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal =
        checkNameOfShape_xjal(_shape, numWorkplacesLabel, "numWorkplacesLabel");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal =
        checkNameOfShape_xjal(_shape, dialogWindow1, "dialogWindow1");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, text2, "text2");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, group, "group");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal =
        checkNameOfShape_xjal(_shape, dialogWindow2, "dialogWindow2");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, text3, "text3");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, group1, "group1");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, group2, "group2");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, line, "line");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, loadingText, "loadingText");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, rectangle4, "rectangle4");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal =
        checkNameOfShape_xjal(
          _shape,
          numWorkplacesLabel1,
          "numWorkplacesLabel1"
        );
      if (_name_xjal != null) return _name_xjal;
      _name_xjal =
        checkNameOfShape_xjal(
          _shape,
          numWorkplacesLabel2,
          "numWorkplacesLabel2"
        );
      if (_name_xjal != null) return _name_xjal;
      _name_xjal =
        checkNameOfShape_xjal(
          _shape,
          numWorkplacesLabel3,
          "numWorkplacesLabel3"
        );
      if (_name_xjal != null) return _name_xjal;
      _name_xjal =
        checkNameOfShape_xjal(
          _shape,
          numWorkplacesLabel4,
          "numWorkplacesLabel4"
        );
      if (_name_xjal != null) return _name_xjal;
      _name_xjal =
        checkNameOfShape_xjal(
          _shape,
          numWorkplacesLabel5,
          "numWorkplacesLabel5"
        );
      if (_name_xjal != null) return _name_xjal;
      _name_xjal =
        checkNameOfShape_xjal(
          _shape,
          numWorkplacesLabel6,
          "numWorkplacesLabel6"
        );
      if (_name_xjal != null) return _name_xjal;
      _name_xjal =
        checkNameOfShape_xjal(
          _shape,
          numWorkplacesLabel7,
          "numWorkplacesLabel7"
        );
      if (_name_xjal != null) return _name_xjal;
    } catch (Exception e) {
      return null;
    }
    return super.getNameOfShape_xjal(_shape);
  }

  @Override
  public int getWindowWidth() {
    return 1500;
  }

  @Override
  public int getWindowHeight() {
    return 800;
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void onDestroy_xjal() {
    onDestroy();
    super.onDestroy_xjal();
  }

  /**
   * Applet class to run experiment as java applet
   */
  @AnyLogicInternalCodegenAPI
  public static class Applet extends JApplet {

    @AnyLogicInternalCodegenAPI
    Simulation ex;

    @Override
    public void init() {
      ex = new Simulation();
      ex.setup(this);
    }

    @Override
    public void destroy() {
      ex.close();
    }

    /**
     * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
     */
    @AnyLogicInternalCodegenAPI
    private static final long serialVersionUID = -9079103501800171972L;
  }

  @AnyLogicInternalCodegenAPI
  public static void main(String[] args) {
    COMMAND_LINE_ARGUMENTS_xjal = args;
    prepareBeforeExperimentStart_xjal(Simulation.class);
    Simulation ex = new Simulation();
    ex.setCommandLineArguments_xjal(args);
    ex.setup(null);
  }

  /**
   * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
   */
  @AnyLogicInternalCodegenAPI
  private static final long serialVersionUID = -9079103501800171972L;

  @Override
  @AnyLogicInternalCodegenAPI
  public void initDefaultRandomNumberGenerator(Engine _e) {
    _e.setDefaultRandomGenerator(new java.util.Random());
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public Main createRoot(Engine engine) {
    // Create the root object
    return new Main(engine, null, null);
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void setupRootParameters(
    final Main self,
    boolean callOnChangeActions
  ) {
    final Main root = self; // for compatibility
    int numHospitals_xjal = editboxHospitals.getIntValue();
    if (callOnChangeActions) {
      self.set_numHospitals(numHospitals_xjal);
    } else {
      self.numHospitals = numHospitals_xjal;
    }
    int numHomes_xjal = editboxHomes.getIntValue();
    if (callOnChangeActions) {
      self.set_numHomes(numHomes_xjal);
    } else {
      self.numHomes = numHomes_xjal;
    }
    int numMarkets_xjal = editboxMarkets.getIntValue();
    if (callOnChangeActions) {
      self.set_numMarkets(numMarkets_xjal);
    } else {
      self.numMarkets = numMarkets_xjal;
    }
    int numSchools_xjal = editboxSchools.getIntValue();
    if (callOnChangeActions) {
      self.set_numSchools(numSchools_xjal);
    } else {
      self.numSchools = numSchools_xjal;
    }
    int numWorkplaces_xjal = editboxWorkplaces.getIntValue();
    if (callOnChangeActions) {
      self.set_numWorkplaces(numWorkplaces_xjal);
    } else {
      self.numWorkplaces = numWorkplaces_xjal;
    }
    int numPeople_xjal = self._numPeople_DefaultValue_xjal();
    if (callOnChangeActions) {
      self.set_numPeople(numPeople_xjal);
    } else {
      self.numPeople = numPeople_xjal;
    }
    int startCovid_xjal = editboxCovid.getIntValue();
    if (callOnChangeActions) {
      self.set_startCovid(startCovid_xjal);
    } else {
      self.startCovid = startCovid_xjal;
    }
    int startFlu_xjal = editboxFlu.getIntValue();
    if (callOnChangeActions) {
      self.set_startFlu(startFlu_xjal);
    } else {
      self.startFlu = startFlu_xjal;
    }
    boolean quarantine_xjal = self._quarantine_DefaultValue_xjal();
    if (callOnChangeActions) {
      self.set_quarantine(quarantine_xjal);
    } else {
      self.quarantine = quarantine_xjal;
    }
    double masks_xjal = 0;
    if (callOnChangeActions) {
      self.set_masks(masks_xjal);
    } else {
      self.masks = masks_xjal;
    }
    double duration_xjal = editboxDuration.getIntValue();
    if (callOnChangeActions) {
      self.set_duration(duration_xjal);
    } else {
      self.duration = duration_xjal;
    }
  }

  /**
   * Engine setup
   */
  @Override
  @AnyLogicInternalCodegenAPI
  public void setupEngine(Engine engine) {
    engine.setATOL(1.0E-5);
    engine.setRTOL(1.0E-5);
    engine.setTTOL(1.0E-5);
    engine.setHTOL(0.0010);
    engine.setSolverODE(Engine.SOLVER_ODE_EULER);
    engine.setSolverNAE(Engine.SOLVER_NAE_MODIFIED_NEWTON);
    engine.setSolverDAE(Engine.SOLVER_DAE_RK45_NEWTON);
    engine.setVMethods(427057);
    engine.setSimultaneousEventsSelectionMode(Engine.EVENT_SELECTION_LIFO);

    engine.setStartTime(0.0);
    engine.setTimeUnit(TIME_UNIT_DAY);
    engine.setStartDate(toDate(2021, JANUARY, 18, 0, 0, 0));
    engine.setRealTimeMode(true);
    engine.setRealTimeScale(1.0);
  }

  /**
   * Experiment setup
   */
  @Override
  @AnyLogicInternalCodegenAPI
  public void setup(java.awt.Container container) {
    setName("abm_multiple_disease_spread : Simulation");

    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
    presentation =
      new ShapeTopLevelPresentationGroup(
        Simulation.this,
        true,
        0,
        0,
        0,
        0,
        image,
        text,
        image1,
        rectangle2,
        text1,
        rectangle3,
        numHomesLabel,
        numHospitalsLabel,
        numMarketsLabel,
        numSchoolsLabel,
        numWorkplacesLabel,
        group,
        group2,
        line,
        loadingText,
        rectangle4,
        numWorkplacesLabel1,
        numWorkplacesLabel2,
        numWorkplacesLabel3,
        numWorkplacesLabel4,
        numWorkplacesLabel5,
        numWorkplacesLabel6,
        numWorkplacesLabel7,
        editboxHomes,
        editboxHospitals,
        editboxMarkets,
        editboxSchools,
        editboxWorkplaces,
        button,
        editboxFlu,
        editboxCovid,
        progressBar,
        editboxDuration
      );
    icon = new ShapeGroup(Simulation.this, true, 0, 0, 0);
    editboxHomes.setValueToDefault();
    editboxHospitals.setValueToDefault();
    editboxMarkets.setValueToDefault();
    editboxSchools.setValueToDefault();
    editboxWorkplaces.setValueToDefault();
    editboxFlu.setValueToDefault();
    editboxCovid.setValueToDefault();
    editboxDuration.setValueToDefault();
    // Setup presentation
    Presentation _p = new Presentation(
      this,
      container instanceof JApplet
        ? Presentation.MODE_APPLET
        : container != null
          ? Presentation.MODE_COMPONENT
          : Presentation.MODE_APPLICATION,
      container
    );
    _p.start();
    _p.setConfirmWindowClose(true);

    Panel _panel = _p.getPanel();
    ToolBar _tb = _p.getToolBar();
    StatusBar _sb = _p.getStatusBar();

    _panel.setZoomEnabled(false);
    _panel.setPanningEnabled(false);
    _panel.setFrameManagementBalance(2.0);

    _sb.setSectionVisible(StatusBar.DATE, false);
    _sb.setSectionVisible(StatusBar.EPS, false);
    _sb.setSectionVisible(StatusBar.EXPERIMENT, false);
    _sb.setSectionVisible(StatusBar.FPS, false);
    _sb.setSectionVisible(StatusBar.MEMORY, false);
    _sb.setSectionVisible(StatusBar.SECONDS, false);
    _sb.setSectionVisible(StatusBar.SIMULATION, false);
    _sb.setSectionVisible(StatusBar.STATUS, false);
    _sb.setSectionVisible(StatusBar.STEP, false);
    _sb.setSectionVisible(StatusBar.TIME, false);
    _tb.setSectionVisible(ToolBar.ANIMATION, false);
    _tb.setSectionVisible(ToolBar.EXECUTION, false);
    _tb.setSectionVisible(ToolBar.FILE, false);
    _tb.setSectionVisible(ToolBar.NAVIGATION, false);
    _tb.setSectionVisible(ToolBar.TIME_SCALE, true);
    _tb.setSectionVisible(ToolBar.VIEW, false);
    _tb.setAllowCustomization(false);
  }
}
